package com.app.composeapp.network.models.trayvideos

import com.google.gson.annotations.SerializedName

data class SubHeading(

	@field:SerializedName("short")
	val jsonMemberShort: String? = null,

	@field:SerializedName("full")
	val full: String? = null
)