package com.example.examensegundoparcial.Model.Network

import com.example.examensegundoparcial.Model.Result
import com.example.examensegundoparcial.Model.UserData
import retrofit2.http.GET

interface UserService {
    @GET("api")
    suspend fun getUser(): UserData
    @GET("api")
    suspend fun getUser2(): Result
}