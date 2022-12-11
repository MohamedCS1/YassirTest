package com.example.yassirmovies.pojo

data class Movie(val adult:Boolean, val background_path:String, val genre_ids:Array<Int>, val id:Int, val original_language:String, val original_title:String, val overview:String, val popularity:Int, val poster_path:String, val release_date:String, val title:String, val video:Boolean, val vote_average:Double, val vote_count:Int)