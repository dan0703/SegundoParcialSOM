package com.example.examensegundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.examensegundoparcial.Model.Movie
import com.example.examensegundoparcial.databinding.ActivityMainBinding
import com.example.examensegundoparcial.databinding.ActivityShowMovieBinding
import com.google.gson.Gson

class ShowMovie : AppCompatActivity() {
    private lateinit var binding: ActivityShowMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        if (intent.hasExtra("key_movie_json")) {
            val movieJson = intent.getStringExtra("key_movie_json")
            val movie = Gson().fromJson(movieJson, Movie::class.java)

            Glide.with(binding.movieImage)
                .load(movie.posterURL)
                .into(binding.movieImage)
            binding.movieTitle.text = movie.title
        }
    }
}
