package com.app.composeapp.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.composeapp.network.models.allvideos.TraysItem
import com.app.composeapp.network.models.trayvideos.VideoShowItem

@Dao
interface VideoShowDao {

    @Insert
    fun insert(videoShowItem: VideoShowItem):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(traysItem: List<VideoShowItem>):List<Long>

    @Query("select * from VideoShowItem where preUrl like :url")
    fun getVideoShowItems(url: String): PagingSource<Int, VideoShowItem>

    @Query("SELECT COUNT(id) from VideoShowItem")
    fun count(): Int
}