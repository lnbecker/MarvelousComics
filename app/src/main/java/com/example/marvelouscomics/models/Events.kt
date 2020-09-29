package com.example.marvelouscomics.models

data class Events (

	val available : Int,
	val collectionURI : String,
	val items : List<String>,
	val returned : Int
)