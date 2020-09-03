package com.example.gadsleaderboard.data.repository

import com.example.gadsleaderboard.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getLearningLeaders() = apiHelper.getLearningLeaders()
    suspend fun getIqLeaders() = apiHelper.getIqLeaders()
}