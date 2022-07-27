package com.app.composeapp.database.dao

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.composeapp.network.models.allvideos.TraysItem

@Dao
interface TrayItemDao {

    @Insert
    fun insert(traysItem: TraysItem):Long

    @Insert
    fun insertAll(traysItem: List<TraysItem>):List<Long>

    @Query("select * from TraysItem")
    fun getTrayItems():PagingSource<Int, TraysItem>

    @Query("SELECT COUNT(id) from TraysItem")
    fun count(): Int

}