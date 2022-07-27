package com.app.composeapp.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.app.composeapp.database.VootDatabase
import com.app.composeapp.network.APIService
import com.app.composeapp.network.models.RemoteKeys
import com.app.composeapp.network.models.VideoRemoteKeys
import com.app.composeapp.network.models.trayvideos.VideoShowItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagingApi::class)
class VideoShowDataSource(var url: String, var database: VootDatabase): RemoteMediator<Int, VideoShowItem>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, VideoShowItem>
    ): MediatorResult {

        val key  = when(loadType) {
            LoadType.APPEND -> {
                getKey()
            }
            LoadType.PREPEND -> {
                return MediatorResult.Success(endOfPaginationReached = true)
            }
            LoadType.REFRESH -> {
                CoroutineScope(Dispatchers.IO).launch {
                    if (database.getVideoShowDao().count() > 0)
                        MediatorResult.Success(false)
                }
                null
            }
        }
        return try {
            if (key != null) {
                if (key.isEndReached) return MediatorResult.Success(endOfPaginationReached = true)
            }

            val page: Int = key?.nextKey ?: 1
            val response = APIService.apiService?.getTrayVideos(url, page)
            val isEndOfPageReached = response?.result?.isEmpty() == true
            CoroutineScope(Dispatchers.IO).launch {
                database.withTransaction {
                    //Storing page number loaded into database.
                    val nextKey = page + 1
                    database.videoRemoteKeyDao().insertKey(
                        VideoRemoteKeys(
                            0,
                            nextKey = nextKey,
                            isEndReached = isEndOfPageReached
                        )
                    )
                }
                response?.result?.let { videoShowItems ->
                    //Converting the time stamp from release date string to millis and saving movies to
                    //database
                    //Inserting movie data to database
                    videoShowItems.forEach {
                        it.preUrl = url
                    }
                    database.getVideoShowDao().insertAll(videoShowItems)
                }
            }
//            if (isEndOfPageReached) {
//                errorHandleLiveData.postValue("No further data is available.")
//            }
            MediatorResult.Success(isEndOfPageReached)
        } catch (exp : Exception) {
//            errorHandleLiveData.postValue(exp.message)
            MediatorResult.Error(exp)
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    private suspend fun getKey(): VideoRemoteKeys? {
        return database.videoRemoteKeyDao().getKeys().firstOrNull()
    }
}