package com.example.gadsleaderboard.ui.submitform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gadsleaderboard.data.repository.MainRepository
import com.example.gadsleaderboard.utils.Resource
import kotlinx.coroutines.Dispatchers

class FormViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var projectLink: String? = null

    fun continueRequest() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.submitProject(email!!, firstName!!, lastName!!, projectLink!!)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}
