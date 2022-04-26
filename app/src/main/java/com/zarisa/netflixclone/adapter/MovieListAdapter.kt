package com.zarisa.netflixclone.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zarisa.netflixclone.R
import com.zarisa.netflixclone.databinding.MovieListItemBinding

typealias like=((button: ImageButton, movie:Movie)->Unit)

class MovieListAdapter (var movieList: MutableList<Movie> = mutableListOf()) : RecyclerView.Adapter<MovieListAdapter.MovieHolder>() {
    inner class MovieHolder(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            try {
                binding.imageViewMovieImage.setImageResource(item.MovieImage)
                binding.textViewMovieName.text=item.movieName
                binding.btnMovieFav.isSelected=item.isLiked
//                binding.btnMovieFav.setOnClickListener { onItemClick(binding.btnMovieFav,item) }
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
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    fun setDate(newList: List<Movie>){
        movieList.clear()
        movieList.addAll(newList)
        notifyDataSetChanged()
    }
}
internal class ImageListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val itemList: MutableList<Movie>?
) : ArrayAdapter<ImageListAdapter.ItemViewHolder>(context, resource) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var itemBinding: MovieListItemBinding

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val holder: ItemViewHolder
        if (convertView == null) {
            itemBinding = MovieListItemBinding.inflate(inflater)
            convertView = itemBinding.root
            holder = ItemViewHolder()
            holder.name = itemBinding.textViewMovieName
            holder.Image = itemBinding.imageViewMovieImage
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemViewHolder
        }
        holder.name?.text = this.itemList?.get(position)?.movieName
        this.itemList?.get(position)?.MovieImage?.let { holder.Image?.setImageResource(it) }
        return convertView
    }

    internal class ItemViewHolder {
        var name: TextView? = null
        var Image: ImageView? = null
    }
}
