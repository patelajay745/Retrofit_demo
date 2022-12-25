package com.ajay.example.retrofit_demo.moviedata

import com.ajay.example.retrofit_demo.moviedata.RetrofitHelper.client
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val Base_url="https://api.themoviedb.org/"

    val interceptor= HttpLoggingInterceptor().apply {
        this.level= HttpLoggingInterceptor.Level.BODY
    }

    val client= OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}