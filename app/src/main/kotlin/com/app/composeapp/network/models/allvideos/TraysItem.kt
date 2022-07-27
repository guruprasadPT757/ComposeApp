package com.app.composeapp.network.models.allvideos

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class TraysItem(

//	@field:SerializedName("tabId")
//	val tabId: String? = null,

//	@field:SerializedName("layoutOptions")
//	val layoutOptionsoutOptions: LayoutOptions? = null,

//	@field:SerializedName("customOptions")
//	val customOptions: List<Any?>? = null,

	@field:SerializedName("description")
	val description: String? = null,
//
//	@field:SerializedName("filters")
//	val filters: List<Any?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

//	@field:SerializedName("segments")
//	val segments: List<Any?>? = null,

//	@field:SerializedName("layout")
//	val layout: String? = null,
//
//	@field:SerializedName("moreLayout")
//	val moreLayout: String? = null,

	@field:SerializedName("apiUrl")
	val apiUrl: String? = null,

//	@field:SerializedName("meta")
//	val meta: Meta? = null,

	@field:SerializedName("trayId")
	val trayId: String? = null,

	@field:SerializedName("apiPath")
	val apiPath: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: String = "",

//	@field:SerializedName("sorts")
//	val sorts: List<Any?>? = null,
//
//	@field:SerializedName("status")
//	val status: String? = null,
//
//	@field:SerializedName("galleryInfo")
//	val galleryInfo: GalleryInfo? = null,
//
//	@field:SerializedName("adMeta")
//	val adMeta: AdMeta? = null,
//
//	@field:SerializedName("totalTrayTabs")
//	val totalTrayTabs: Int? = null,
//
//	@field:SerializedName("trayTabs")
//	val trayTabs: List<TrayTabsItem?>? = null,
//
//	@field:SerializedName("addTopPadding")
//	val addTopPadding: Boolean? = null
)