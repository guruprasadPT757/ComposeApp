package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class LayoutOptions(

	@field:SerializedName("imageBaseUrl")
	val imageBaseUrl: ImageBaseUrl? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("aspectRatio")
	val aspectRatio: String? = null,

	@field:SerializedName("creativeLayout")
	val creativeLayout: String? = null,

	@field:SerializedName("platform")
	val platform: Platform? = null,

	@field:SerializedName("height")
	val height: Int? = null
)