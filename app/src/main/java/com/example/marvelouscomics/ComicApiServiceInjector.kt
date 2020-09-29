package com.example.marvelouscomics

import com.example.marvelouscomics.retrofit.ComicsApiService

class ComicApiServiceInjector: ApiServiceInjector {
    override fun apiService() : ComicsApiService {
        return ComicsApiService()
    }
}