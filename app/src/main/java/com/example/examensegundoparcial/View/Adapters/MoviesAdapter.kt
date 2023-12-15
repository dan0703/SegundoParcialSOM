package com.example.examensegundoparcial.View.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examensegundoparcial.Model.Movie
import com.example.examensegundoparcial.R
import com.example.examensegundoparcial.databinding.MovieItemBinding

class MoviesAdapter(private var movieList: List<Movie>, private val onClickListener:(Movie) -> Unit): RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>(){
    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = MovieItemBinding.bind(itemView)
        fun render(movie: Movie, onClickListener:(Movie) -> Unit){
            binding.recipeTitle.text = movie.title
            Glide.with(binding.recipeImage)
                .load(movie.posterURL)
                .into(binding.recipeImage)
            itemView.setOnClickListener(){
                onClickListener(movie)
            }
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.movie_item, viewGroup, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size
    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        viewHolder.render(item, onClickListener)
    }
    fun updateRecipeList(movieList: List<Movie>){
        this.movieList = movieList
        notifyDataSetChanged()
    }
}