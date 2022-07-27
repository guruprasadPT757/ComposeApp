package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class AllVideoResponse(

	@field:SerializedName("editable")
	val editable: Boolean? = null,

	@field:SerializedName("customizable")
	val customizable: Boolean? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("trays")
	val trays: List<TraysItem>? = null,

	@field:SerializedName("platformId")
	val platformId: String? = null,

	@field:SerializedName("default")
	val jsonMemberDefault: Boolean? = null,

	@field:SerializedName("groupName")
	val groupName: String? = null,

	@field:SerializedName("viewConfigUrl")
	val viewConfigUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("variant")
	val variant: String? = null,

	@field:SerializedName("basePlatform")
	val basePlatform: String? = null,

	@field:SerializedName("trayCount")
	val trayCount: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("includeBaseTrays")
	val includeBaseTrays: Boolean? = null,

	@field:SerializedName("updated")
	val updated: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("page")
	val page: Int? = null
)