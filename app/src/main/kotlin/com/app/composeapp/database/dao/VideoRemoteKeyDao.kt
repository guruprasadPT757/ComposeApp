package com.app.composeapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.composeapp.network.models.VideoRemoteKeys

@Dao
interface VideoRemoteKeyDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAll(remoteKey: List<VideoRemoteKeys>)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertKey(remoteKey: VideoRemoteKeys)

        @Query("SELECT * FROM remote_keys WHERE id = :repoId")
        suspend fun remoteKeysRepoId(repoId: Int): VideoRemoteKeys?

        @Query("DELETE FROM remote_keys")
        suspend fun clearRemoteKeys()

        @Query("SELECT * FROM remote_keys")
        suspend fun getKeys():List<VideoRemoteKeys>


}