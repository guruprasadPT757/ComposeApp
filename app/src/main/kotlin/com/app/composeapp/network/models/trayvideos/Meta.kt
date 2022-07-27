package com.app.composeapp.network.models.trayvideos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Meta(

	@PrimaryKey(autoGenerate = true)
	val metaId: Int = 0,

//	@field:SerializedName("downloadable")
//	val downloadable: String? = null,

//	@field:SerializedName("languages")
//	val languages: List<String>? = null,

//	@field:SerializedName("contentSubject")
//	val contentSubject: String? = null,

//	@field:SerializedName("carouselMeta")
//	val carouselMeta: CarouselMeta? = null,

//	@field:SerializedName("SBU")
//	val sBU: String? = null,

//	@field:SerializedName("synopsis")
//	val synopsis: Synopsis? = null,

	@Embedded
	@field:SerializedName("title")
	val title: Title? = null,

//	@field:SerializedName("type")
//	val type: String? = null,

//	@field:SerializedName("characters")
//	val characters: List<String>? = null,

//	@field:SerializedName("subHeading")
//	val subHeading: SubHeading? = null,
//
//	@field:SerializedName("series")
//	val series: Series? = null,
//
//	@field:SerializedName("genres")
//	val genres: List<String>? = null,
//
//	@field:SerializedName("contributors")
//	val contributors: List<String>? = null,
//
	@field:SerializedName("contentDescriptor")
	val contentDescriptor: String? = null,
//
//	@field:SerializedName("releaseYear")
//	val releaseYear: Int? = null,
//
//	@field:SerializedName("age")
//	val age: String? = null,

	@field:SerializedName("label")
	val label: String? = null
)