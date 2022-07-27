package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class FiltersItem(

	@field:SerializedName("values")
	val values: String? = null,

	@field:SerializedName("scope")
	val scope: String? = null,

	@field:SerializedName("exposed")
	val exposed: Boolean? = null,

	@field:SerializedName("propagate")
	val propagate: Boolean? = null,

	@field:SerializedName("preset")
	val preset: Boolean? = null,

	@field:SerializedName("validValues")
	val validValues: List<Any?>? = null,

	@field:SerializedName("key")
	val key: String? = null
)