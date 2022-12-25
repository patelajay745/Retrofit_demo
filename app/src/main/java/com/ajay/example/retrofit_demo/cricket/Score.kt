package com.ajay.example.retrofit_demo.cricket


import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("inning")
    val inning: String,
    @SerializedName("o")
    val o: Double,
    @SerializedName("r")
    val r: Int,
    @SerializedName("w")
    val w: Int
)