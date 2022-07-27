package com.app.composeapp.database

import android.content.Context
import androidx.room.*
import com.app.composeapp.database.dao.RemoteKeysDao
import com.app.composeapp.database.dao.TrayItemDao
import com.app.composeapp.database.dao.VideoRemoteKeyDao
import com.app.composeapp.database.dao.VideoShowDao
import com.app.composeapp.network.models.RemoteKeys
import com.app.composeapp.network.models.VideoRemoteKeys
import com.app.composeapp.network.models.allvideos.TraysItem
import com.app.composeapp.network.models.trayvideos.*

@Database(entities = [TraysItem::class, VideoShowItem::class, Meta::class, Details::class,
    Image::class, FooterImage::class, Title::class, RemoteKeys::class, VideoRemoteKeys::class],
    version = 1, exportSchema = false)
abstract class VootDatabase: RoomDatabase() {

    abstract fun getTrayItemDao(): TrayItemDao
    abstract fun getVideoShowDao(): VideoShowDao
    abstract fun remoteKeyDao(): RemoteKeysDao
    abstract fun videoRemoteKeyDao(): VideoRemoteKeyDao

    companion object {
        var database: VootDatabase? = null
        fun getInstance(context: Context):VootDatabase {
            if (database == null) {
                database = Room.databaseBuilder(context,
                    VootDatabase::class.java,"voot_db").build()
            }
            return database!!
        }
    }

}