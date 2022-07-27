package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class AssetsItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("updated")
	val updated: Int? = null,

	@field:SerializedName("trailerId")
	val trailerId: Any? = null
)