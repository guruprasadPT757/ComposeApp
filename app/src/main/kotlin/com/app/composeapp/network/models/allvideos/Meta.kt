package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class Meta(

	@field:SerializedName("contentVersions")
	val contentVersions: List<String?>? = null,

	@field:SerializedName("isAvodTray")
	val isAvodTray: Boolean? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("assets")
	val assets: List<AssetsItem?>? = null,

	@field:SerializedName("trayType")
	val trayType: String? = null,

	@field:SerializedName("isPremiumTray")
	val isPremiumTray: Boolean? = null,

	@field:SerializedName("userTray")
	val userTray: Boolean? = null
)