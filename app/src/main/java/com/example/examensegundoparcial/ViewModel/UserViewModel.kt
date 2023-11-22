package com.example.examensegundoparcial.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examensegundoparcial.Model.Result
import com.example.examensegundoparcial.Model.UserProvider

class UserViewModel: ViewModel() {
    val userModel = MutableLiveData<Result>()

    suspend fun getNewUser(){
        val currentUser = UserProvider.getNewUser()
        userModel.postValue(currentUser)
    }
}