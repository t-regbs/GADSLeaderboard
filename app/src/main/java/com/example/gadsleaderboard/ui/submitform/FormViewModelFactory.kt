package com.example.gadsleaderboard.ui.submitform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboard.data.api.ApiHelper
import com.example.gadsleaderboard.data.repository.MainRepository

class FormViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FormViewModel::class.java)) {
            return FormViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}