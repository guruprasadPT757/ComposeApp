package com.app.composeapp.network.models.trayvideos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class VideoShowItem(

	@field:SerializedName("telecasted")
	val telecasted: Int? = null,

	@field:SerializedName("ingested")
	val ingested: Double? = null,

	@field:SerializedName("created")
	val created: Int? = null,

	@Embedded
	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@Embedded
	@field:SerializedName("details")
	val details: Details? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int = 0,

	var preUrl: String? = null,

//
//	@field:SerializedName("updated")
//	val updated: Int? = null,
//
//	@field:SerializedName("slug")
//	val slug: String? = null
)