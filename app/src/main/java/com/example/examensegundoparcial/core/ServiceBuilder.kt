package com.example.examensegundoparcial.core

import com.example.examensegundoparcial.Model.Network.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userService: UserService = retrofit.create(UserService::class.java)
}