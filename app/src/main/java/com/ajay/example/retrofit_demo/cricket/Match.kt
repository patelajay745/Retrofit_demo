package com.ajay.example.retrofit_demo.cricket


import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("bbbEnabled")
    val bbbEnabled: Boolean,
    @SerializedName("date")
    val date: String,
    @SerializedName("dateTimeGMT")
    val dateTimeGMT: String,
    @SerializedName("fantasyEnabled")
    val fantasyEnabled: Boolean,
    @SerializedName("hasSquad")
    val hasSquad: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("matchEnded")
    val matchEnded: Boolean,
    @SerializedName("matchStarted")
    val matchStarted: Boolean,
    @SerializedName("matchType")
    val matchType: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: List<Score>,
    @SerializedName("series_id")
    val seriesId: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("teamInfo")
    val teamInfo: List<TeamInfo>,
    @SerializedName("teams")
    val teams: List<String>,
    @SerializedName("venue")
    val venue: String
)