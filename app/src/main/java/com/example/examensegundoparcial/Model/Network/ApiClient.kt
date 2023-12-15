package com.example.examensegundoparcial.Model.Network

import com.example.examensegundoparcial.Model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("movies/horror")
    suspend fun getMovieList(): Response<List<Movie>>
}