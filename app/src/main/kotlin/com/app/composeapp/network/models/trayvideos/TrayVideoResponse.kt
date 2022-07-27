package com.app.composeapp.network.models.trayvideos

import com.google.gson.annotations.SerializedName

data class TrayVideoResponse(

	@field:SerializedName("result")
	val result: List<VideoShowItem>? = null,

	@field:SerializedName("totalAsset")
	val totalAsset: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null
)