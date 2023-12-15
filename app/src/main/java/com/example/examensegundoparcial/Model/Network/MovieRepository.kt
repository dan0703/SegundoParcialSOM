package com.example.examensegundoparcial.Model.Network

import com.example.examensegundoparcial.Model.Movie
import com.example.examensegundoparcial.Model.MovieProvider

class MovieRepository {
    private val api = MovieService()

    suspend fun getMovieList(): List<Movie>{
        val response = api.getMovieList()
        MovieProvider.movieList = response
        return response
    }
}