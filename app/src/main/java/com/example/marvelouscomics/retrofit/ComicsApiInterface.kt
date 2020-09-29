package com.example.marvelouscomics.retrofit

import com.example.marvelouscomics.models.Comic
import io.reactivex.Observable

interface ComicsApiInterface {
    fun getComics(): Observable<List<Comic>>
}