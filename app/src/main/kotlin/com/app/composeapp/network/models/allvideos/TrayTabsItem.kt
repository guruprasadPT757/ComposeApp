package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class TrayTabsItem(

	@field:SerializedName("apiUrl")
	val apiUrl: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("queryId")
	val queryId: String? = null
)