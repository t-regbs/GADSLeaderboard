package com.example.gadsleaderboard.ui.learningleaders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboard.data.api.ApiHelper
import com.example.gadsleaderboard.data.repository.MainRepository

class LearningViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearningLeadersViewModel::class.java)) {
            return LearningLeadersViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}