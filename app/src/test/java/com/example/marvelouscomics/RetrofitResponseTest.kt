package com.example.marvelouscomics

import com.example.marvelouscomics.retrofit.ComicsApiService
import org.junit.Test

class RetrofitResponseTest {

    @Test
    fun `can get comics` () {
        val api = ComicsApiService()
        val response = api.getComics()
        response.subscribe {
            assert(it.isNotEmpty())
        }
    }
}