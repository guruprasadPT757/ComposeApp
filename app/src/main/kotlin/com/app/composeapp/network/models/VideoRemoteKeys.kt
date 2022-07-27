package com.app.composeapp.network.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video_remote_keys")
data class VideoRemoteKeys (
        @PrimaryKey(autoGenerate = false)
        val id: Int,
        val nextKey: Int?,
        val isEndReached: Boolean
        )