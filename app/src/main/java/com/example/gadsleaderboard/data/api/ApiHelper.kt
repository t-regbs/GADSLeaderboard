package com.example.gadsleaderboard.data.api

class ApiHelper(private val apiService: ApiService, private val submitService: SubmitService) {
    suspend fun getLearningLeaders() = apiService.getLearningLeaders()
    suspend fun getIqLeaders() = apiService.getIQLeaders()
    suspend fun submitProject(email: String, firstName: String, lastName: String, link: String)
            = submitService.submitProject(email, firstName, lastName, link)
}