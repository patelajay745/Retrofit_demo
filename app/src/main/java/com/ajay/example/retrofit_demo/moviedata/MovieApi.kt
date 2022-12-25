package com.ajay.example.retrofit_demo.moviedata

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("3/movie/popular")
    suspend fun getMovies(@Query("api_key")api_key:String): Response<MovieList>

    //base _url +"3/movie/latest"+?api_key=eb00f3b7d7c726005d4f1a7b2ee07d22
}