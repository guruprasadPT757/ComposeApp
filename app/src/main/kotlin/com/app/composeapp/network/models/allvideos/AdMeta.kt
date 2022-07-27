package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class AdMeta(

	@field:SerializedName("layout")
	val layout: String? = null,

	@field:SerializedName("screen")
	val screen: String? = null,

	@field:SerializedName("subType")
	val subType: String? = null,

	@field:SerializedName("position")
	val position: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)