package com.app.composeapp.network.models.trayvideos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Details(

	@PrimaryKey(autoGenerate = true)
	val detailsId: Int = 0,

	@Embedded
	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("externalId")
	val externalId: String? = null,

	@field:SerializedName("mediaType")
	val mediaType: String? = null,

	@Embedded
	@field:SerializedName("footerImage")
	val footerImage: FooterImage? = null
)