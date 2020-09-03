package com.example.gadsleaderboard.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboard.data.api.ApiHelper
import com.example.gadsleaderboard.data.repository.MainRepository

class IqViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IqLeadersViewModel::class.java)) {
            return IqLeadersViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}