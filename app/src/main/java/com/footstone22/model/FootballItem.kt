package com.footstone22.model


import com.google.gson.annotations.SerializedName

data class FootballItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("topPlayers")
    val topPlayers: List<TopPlayer>
)