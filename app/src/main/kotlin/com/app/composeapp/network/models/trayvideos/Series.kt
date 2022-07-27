package com.app.composeapp.network.models.trayvideos

import com.google.gson.annotations.SerializedName

data class Series(

	@field:SerializedName("showId")
	val showId: Int? = null,

	@field:SerializedName("showName")
	val showName: String? = null,

	@field:SerializedName("episodeNo")
	val episodeNo: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("season")
	val season: Int? = null,

	@field:SerializedName("episode")
	val episode: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("seasonDisplay")
	val seasonDisplay: String? = null
)