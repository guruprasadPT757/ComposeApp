package com.app.composeapp.network.models.allvideos

import com.google.gson.annotations.SerializedName

data class Tv(

	@field:SerializedName("showSelectLabel")
	val showSelectLabel: Boolean? = null,

	@field:SerializedName("showAssetTitle")
	val showAssetTitle: Boolean? = null,

	@field:SerializedName("scrolling")
	val scrolling: Boolean? = null,

	@field:SerializedName("gutterWidth")
	val gutterWidth: Int? = null,

	@field:SerializedName("showTrayTitle")
	val showTrayTitle: Boolean? = null,

	@field:SerializedName("numberOfCards")
	val numberOfCards: Float? = null,

	@field:SerializedName("scrollDuration")
	val scrollDuration: Int? = null,

	@field:SerializedName("flexCarousel")
	val flexCarousel: Boolean? = null,

	@field:SerializedName("selectLabelFontSize")
	val selectLabelFontSize: Int? = null
)