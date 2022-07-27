package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class ImageBaseUrl(

	@field:SerializedName("imgURL_0.5")
	val imgURL05: String? = null,

	@field:SerializedName("imgURL_1")
	val imgURL1: String? = null,

	@field:SerializedName("imgURL_2")
	val imgURL2: String? = null,

	@field:SerializedName("imgURL_3")
	val imgURL3: String? = null
)