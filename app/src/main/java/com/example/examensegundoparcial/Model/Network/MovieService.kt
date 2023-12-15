package com.example.examensegundoparcial.Model.Network

import com.example.examensegundoparcial.Model.Movie
import com.example.examensegundoparcial.core.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {
    private val retrofit = ServiceBuilder.getRetrofit()

    suspend fun getMovieList(): List<Movie>{
        return withContext(Dispatchers.IO) {
            try {
                val response = retrofit.create(ApiClient::class.java).getMovieList()
                response.body() ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }
    }
}