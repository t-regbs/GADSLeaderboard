package com.example.gadsleaderboard.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SubmitBuilder {

    private const val BASE_URL = "https://docs.google.com/forms/d/e/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val submitService: SubmitService = getRetrofit().create(SubmitService::class.java)
}