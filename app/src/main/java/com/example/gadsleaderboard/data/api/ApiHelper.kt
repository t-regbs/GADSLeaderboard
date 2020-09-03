package com.example.gadsleaderboard.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getLearningLeaders() = apiService.getLearningLeaders()
    suspend fun getIqLeaders() = apiService.getIQLeaders()
}