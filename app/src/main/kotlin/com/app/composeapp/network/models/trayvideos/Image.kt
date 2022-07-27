package com.app.composeapp.network.models.trayvideos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Image(

	@PrimaryKey(autoGenerate = true)
	val imageId: Int = 0,

	@field:SerializedName("16x9")
	val jsonMemberImage16x9: String? = null,

	@field:SerializedName("1x1")
	val jsonMemberImage1x1: String? = null,

	@field:SerializedName("2x3")
	val jsonMemberImage2x3: String? = null,

	@field:SerializedName("4x3")
	val jsonMemberImage4x3: String? = null,

	@field:SerializedName("imageUri2")
	val imageUri21: String? = null,

	@field:SerializedName("animation16x9")
	val animationImage16x9: String? = null,

	@field:SerializedName("9x16")
	val jsonMemberImage9x16: String? = null
)