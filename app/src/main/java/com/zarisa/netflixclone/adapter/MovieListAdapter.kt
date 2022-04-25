package com.zarisa.netflixclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zarisa.netflixclone.databinding.MovieListItemBinding

typealias like=((button: ImageButton, movie:Movie)->Unit)

class MovieListAdapter ( val onItemClick:like):
    ListAdapter<Movie, MovieListAdapter.MovieHolder>(MovieDiffCallback) {
    inner class MovieHolder(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            try {
                binding.imageViewMovieImage.setImageResource(item.MovieImage)
                binding.textViewMovieName.text=item.movieName
                binding.btnFav.isSelected=item.isLiked
                binding.btnFav.setOnClickListener { onItemClick(binding.btnFav,item) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.MovieHolder {
        val binding= MovieListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.MovieHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }
}
object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}


