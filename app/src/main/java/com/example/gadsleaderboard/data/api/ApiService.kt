package com.example.gadsleaderboard.data.api

import com.example.gadsleaderboard.models.IqLeader
import com.example.gadsleaderboard.models.LearningLeader
import retrofit2.http.GET

interface ApiService {
    @GET("/api/hours")
    suspend fun getLearningLeaders(): List<LearningLeader>

    @GET("/api/skilliq")
    suspend fun getIQLeaders(): List<IqLeader>
}