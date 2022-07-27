package com.app.composeapp

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.composeapp.database.VootDatabase
import com.app.composeapp.network.APIService
import com.app.composeapp.network.models.allvideos.TraysItem
import com.app.composeapp.network.models.trayvideos.TrayVideoResponse
import com.app.composeapp.network.models.trayvideos.VideoShowItem
import com.app.composeapp.pagingsource.TraysItemDataSource
import com.app.composeapp.pagingsource.VideoShowDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val allMoviesMutableList = mutableStateListOf<TraysItem>()
    val trayMoviesMutableMap = mutableStateMapOf<String, TrayVideoResponse>()

    val apiService = APIService.getInstance()
    lateinit var vootDatabase: VootDatabase

    fun getTrays():Flow<PagingData<TraysItem>> {
        val pagingSource = {vootDatabase.getTrayItemDao().getTrayItems()}
        @OptIn(ExperimentalPagingApi::class)
        return Pager(PagingConfig(4, enablePlaceholders = false),
            initialKey = 1,
            remoteMediator = TraysItemDataSource(vootDatabase),
            pagingSource).flow
    }

    fun loadVideoShows(url: String):Flow<PagingData<VideoShowItem>> {
        val pagingSource = {vootDatabase.getVideoShowDao().getVideoShowItems(url)}
        @OptIn(ExperimentalPagingApi::class)
        return Pager(PagingConfig(4, enablePlaceholders = false),
            initialKey = 1,
            remoteMediator = VideoShowDataSource(url, vootDatabase),
            pagingSource).flow
    }

    fun getAllVideosInfo() {
        viewModelScope.launch {
            val response = apiService.getAllVideos(null)
            response.let {
                it.trays?.filter { it.apiUrl?.isNotEmpty() == true }?.let { trays ->
                    allMoviesMutableList.addAll(trays)
                }
            }
            allMoviesMutableList.forEach { tray ->
                loadVideos(tray.apiUrl?:"")
            }
        }
    }

    fun loadVideos(apiUrl: String) {
        viewModelScope.launch {
            try {
                val trayResponse = apiService.getTrayVideos(apiUrl ?: "", null)
                trayResponse.let {
                    trayMoviesMutableMap[apiUrl ?: ""] = it
                }
            } catch (exp: Exception) {

            }
        }
    }
}