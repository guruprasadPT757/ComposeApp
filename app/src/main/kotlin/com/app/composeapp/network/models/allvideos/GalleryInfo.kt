package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class GalleryInfo(

	@field:SerializedName("trayGradientStartColor")
	val trayGradientStartColor: String? = null,

	@field:SerializedName("introductoryText")
	val introductoryText: String? = null,

	@field:SerializedName("trayGradientEndColor")
	val trayGradientEndColor: String? = null,

	@field:SerializedName("gradientAngle")
	val gradientAngle: Int? = null
)