package com.app.composeapp.network.models.trayvideos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class FooterImage(

	@PrimaryKey(autoGenerate = true)
	val footerImageId: Int = 0,

	@field:SerializedName("16x9")
	val jsonMember16x9: String? = null
)