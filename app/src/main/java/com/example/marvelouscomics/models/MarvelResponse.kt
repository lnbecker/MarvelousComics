package com.example.marvelouscomics.models

//The base response from the Marvel API
data class MarvelResponse (

	val code : Int,
	val status : String,
	val copyright : String,
	val attributionText : String,
	val attributionHTML : String,
	val etag : String,
	val data : Data
)