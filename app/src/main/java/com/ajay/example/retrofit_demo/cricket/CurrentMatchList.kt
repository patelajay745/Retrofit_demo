package com.ajay.example.retrofit_demo.cricket


import com.google.gson.annotations.SerializedName

data class CurrentMatchList(
    @SerializedName("apikey")
    val apikey: String,
    @SerializedName("data")
    val match: List<Match>,
    @SerializedName("info")
    val info: Info,
    @SerializedName("status")
    val status: String
)