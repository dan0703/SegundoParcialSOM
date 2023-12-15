package com.example.examensegundoparcial.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.examensegundoparcial.Model.Movie
import com.example.examensegundoparcial.Model.MovieProvider
import com.example.examensegundoparcial.Model.Network.MovieRepository
import com.example.examensegundoparcial.R
import com.example.examensegundoparcial.ShowMovie
import com.example.examensegundoparcial.View.Adapters.MoviesAdapter
import com.example.examensegundoparcial.ViewModel.MovieViewModel
import com.example.examensegundoparcial.core.ServiceBuilder
import com.example.examensegundoparcial.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private var movieMutableList: MutableList<Movie> = MovieProvider.movieList.toMutableList()
    private lateinit var movieAdapter : MoviesAdapter


    private val movieViewModel:MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.searchEditText.addTextChangedListener {movieName ->
            val moviesFiltered =
                movieMutableList.filter { movie ->
                    movie.title.lowercase().contains(movieName.toString().lowercase())
                }
            movieAdapter.updateRecipeList(moviesFiltered)

        }
        setContentView(binding.root)
        initObservables()
        initListeners()
        initRecyclerView()
    }
    fun initRecyclerView() {
        val movieRepository = MovieRepository()
        binding.recyclerviewMovies.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            movieMutableList = movieRepository.getMovieList().toMutableList()
            withContext(Dispatchers.Main) {
                movieAdapter = MoviesAdapter(movieMutableList){ movie: Movie -> onMovieSelected(movie) }
                binding.recyclerviewMovies.adapter = movieAdapter
            }
        }
    }
    private fun onMovieSelected(movie: Movie) {
        val movieJson = Gson().toJson(movie)

        val intent = Intent(this, ShowMovie::class.java)

        intent.putExtra("key_movie_json", movieJson)

        startActivity(intent)
    }


    private fun initListeners() {

    }

    private fun initObservables() {

    }
}