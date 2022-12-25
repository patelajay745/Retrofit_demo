package com.ajay.example.retrofit_demo.cricket

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CricketApi {

    @GET("v1/currentMatches")
    suspend fun getCurrentMatches(@Query("apikey")api_key:String,@Query("offset")offset:String):Response<CurrentMatchList>

    //https://api.cricapi.com/v1/currentMatches?apikey=9a27591c-3fe7-4a56-8611-40c992d062eb&offset=0
}