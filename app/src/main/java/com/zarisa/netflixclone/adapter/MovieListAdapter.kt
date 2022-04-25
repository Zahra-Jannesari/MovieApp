package com.zarisa.netflixclone.adapter

import android.content.Context
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

class MovieListAdapter (var context: Context, var movieList: MutableList<Movie> = mutableListOf()):BaseAdapter(){

//    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
//        val itemImage=view.findViewById<ImageView>(R.id.imageView_movieImage)
//        val itemName=view.findViewById<TextView>(R.id.textView_movieName)
//        val itemBtnFav=view.findViewById<ImageButton>(R.id.btn_movieFav)
//
//        fun bind(movie: Movie){
//            itemImage.setImageResource(movie.MovieImage)
//            itemName.text=movie.movieName
//            itemBtnFav.isSelected=movie.isLiked
//        }
//    }
    override fun getCount(): Int {
        return movieList.size
    }

    override fun getItem(p0: Int): Any {
        return movieList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view:View= View.inflate(context, R.layout.movie_list_item,null)

        val itemImage=view.findViewById<ImageView>(R.id.imageView_movieImage)
        val itemName=view.findViewById<TextView>(R.id.textView_movieName)
        val itemBtnFav=view.findViewById<ImageButton>(R.id.btn_movieFav)

        var movie= movieList[p0]

        itemImage.setImageResource(movie.MovieImage)
        itemName.text=movie.movieName
        itemBtnFav.isSelected=movie.isLiked
        return view
    }

    fun addList(mutableList: MutableList<Movie>){
        movieList=mutableList
    }
}

