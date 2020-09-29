package com.example.marvelouscomics.retrofit

import com.example.marvelouscomics.models.MarvelResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelComicsApi {

    @GET("/v1/public/comics?format=comic&formatType=comic&ts=1&apikey={API KEY GOES HERE}&hash={MD5 DIGEST GOES HERE}")
    fun getData(): Observable<MarvelResponse>
}