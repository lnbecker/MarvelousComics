package com.example.marvelouscomics

import com.example.marvelouscomics.retrofit.ComicsApiService

interface ApiServiceInjector {
    fun apiService() : ComicsApiService
}