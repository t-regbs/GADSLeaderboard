package com.example.gadsleaderboard.ui.skilliqleaders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gadsleaderboard.data.repository.MainRepository
import com.example.gadsleaderboard.utils.Resource
import kotlinx.coroutines.Dispatchers

class IqLeadersViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getIqLeaders() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getIqLeaders()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}