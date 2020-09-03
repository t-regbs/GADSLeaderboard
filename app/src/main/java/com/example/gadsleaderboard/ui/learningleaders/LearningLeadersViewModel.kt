package com.example.gadsleaderboard.ui.learningleaders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gadsleaderboard.data.repository.MainRepository
import com.example.gadsleaderboard.utils.Resource
import kotlinx.coroutines.Dispatchers

class LearningLeadersViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getLearningLeaders() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getLearningLeaders()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}