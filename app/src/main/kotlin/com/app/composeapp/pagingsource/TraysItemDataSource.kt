package com.app.composeapp.pagingsource

import android.media.MediaDataSource
import androidx.paging.*
import androidx.room.withTransaction
import com.app.composeapp.database.VootDatabase
import com.app.composeapp.network.APIService
import com.app.composeapp.network.APIService.Companion.apiService
import com.app.composeapp.network.models.RemoteKeys
import com.app.composeapp.network.models.allvideos.TraysItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagingApi::class)
class TraysItemDataSource(var database: VootDatabase): RemoteMediator<Int, TraysItem>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TraysItem>
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
                    if (database.getTrayItemDao().count() > 0)
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
            val response = apiService?.getAllVideos( page)
            val isEndOfPageReached = response?.trays?.isEmpty() == true
            CoroutineScope(Dispatchers.IO).launch {
                database.withTransaction {
                    //Storing page number loaded into database.
                    val nextKey = page + 1
                    database.remoteKeyDao().insertKey(
                        RemoteKeys(
                            0,
                            nextKey = nextKey,
                            isEndReached = isEndOfPageReached
                        )
                    )
                }
                response?.trays?.let { trays ->
                    //Converting the time stamp from release date string to millis and saving movies to
                    //database
                    //Inserting movie data to database
                    database.getTrayItemDao().insertAll(trays)
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
        return InitializeAction.SKIP_INITIAL_REFRESH
    }

    private suspend fun getKey(): RemoteKeys? {
        return database.remoteKeyDao().getKeys().firstOrNull()
    }
}