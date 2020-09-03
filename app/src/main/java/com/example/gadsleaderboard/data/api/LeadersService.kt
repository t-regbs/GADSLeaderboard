package com.example.gadsleaderboard.data.api

import com.example.gadsleaderboard.models.IqLeader
import com.example.gadsleaderboard.models.LearningLeader
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface LeadersService {
    @GET("/api/hours")
    fun getLearningLeaders(): Call<MutableList<LearningLeader>>

    @GET("/api/skilliq")
    fun getIQLeaders(): Call<MutableList<IqLeader>>

    companion object{
        operator fun invoke(): LeadersService{
            return Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LeadersService::class.java)
        }
    }
}