package com.footstone22.models


import com.google.gson.annotations.SerializedName

data class BalllItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("topPlayers")
    val topPlayers: List<TopPlayer>
)