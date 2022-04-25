package com.zarisa.netflixclone.adapter

import com.zarisa.netflixclone.R

data class Movie(var MovieImage:Int,var movieName:String,var isLiked:Boolean=false)
object Repository{
    var movieList= mutableListOf<Movie>()
    var likedMovieList= mutableListOf<Movie>()
    fun addTestDate(){
        for (i in 1..30){
            movieList.add(Movie(R.drawable.acton_example1,"Movie$i"))
        }
    }
    fun fixLikedList(){
        likedMovieList.clear()
        for (i in movieList){
            if (i.isLiked){
                likedMovieList.add(i)
            }
        }
    }
}
