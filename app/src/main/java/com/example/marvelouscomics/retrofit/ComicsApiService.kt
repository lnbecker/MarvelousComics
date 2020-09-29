package com.example.marvelouscomics.retrofit

import com.example.marvelouscomics.models.Comic
import com.example.marvelouscomics.models.ComicResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ComicsApiService: ComicsApiInterface {

    var baseUrl = "https://gateway.marvel.com"
    val service : MarvelComicsApi

    init {
        service = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MarvelComicsApi::class.java)

    }

    private fun ComicResult.toComic() = Comic(title = title, description = description, imageUrl = thumbnail.path + "." + thumbnail.extension, detailsUrl = urls[0].url)

    override fun getComics(): Observable<List<Comic>> {
        return service.getData()
            .map { marvelResponse ->
                    marvelResponse.data.results.map { comicResult: ComicResult -> comicResult.toComic() }
            }
    }

}


