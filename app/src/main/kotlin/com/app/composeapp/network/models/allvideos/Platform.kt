package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class Platform(

	@field:SerializedName("tablet")
	val tablet: Tablet? = null,

	@field:SerializedName("tv")
	val tv: Tv? = null,

	@field:SerializedName("web")
	val web: Web? = null,

	@field:SerializedName("mobile")
	val mobile: Mobile? = null
)