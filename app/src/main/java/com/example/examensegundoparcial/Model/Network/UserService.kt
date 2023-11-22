package com.example.examensegundoparcial.Model.Network

import com.example.examensegundoparcial.Model.User
import retrofit2.http.GET

interface UserService {
    @GET("api")
    suspend fun getUser(): User
}