package com.ajay.example.retrofit_demo.cricket


import com.google.gson.annotations.SerializedName

data class TeamInfo(
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortname")
    val shortname: String
)