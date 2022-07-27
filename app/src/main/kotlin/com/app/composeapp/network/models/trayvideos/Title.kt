package com.app.composeapp.network.models.trayvideos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Title(

	@PrimaryKey(autoGenerate = true)
	val titleId: Int = 0,

	@field:SerializedName("short")
	val jsonMemberShort: String? = null,

	@field:SerializedName("full")
	val full: String? = null
)