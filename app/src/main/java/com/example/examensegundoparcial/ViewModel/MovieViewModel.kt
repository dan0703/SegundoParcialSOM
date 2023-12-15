package com.example.examensegundoparcial.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examensegundoparcial.Model.Movie
import com.example.examensegundoparcial.Model.MovieProvider

class MovieViewModel: ViewModel() {
    val movieModel = MutableLiveData<Movie>()
}