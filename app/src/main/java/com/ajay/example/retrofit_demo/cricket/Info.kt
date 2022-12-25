package com.ajay.example.retrofit_demo.cricket


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("cache")
    val cache: Int,
    @SerializedName("credits")
    val credits: Int,
    @SerializedName("hitsLimit")
    val hitsLimit: Int,
    @SerializedName("hitsToday")
    val hitsToday: Int,
    @SerializedName("hitsUsed")
    val hitsUsed: Int,
    @SerializedName("offsetRows")
    val offsetRows: Int,
    @SerializedName("queryTime")
    val queryTime: Double,
    @SerializedName("s")
    val s: Int,
    @SerializedName("server")
    val server: Int,
    @SerializedName("totalRows")
    val totalRows: Int
)