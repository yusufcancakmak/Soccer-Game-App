package com.footstone22.model


import com.google.gson.annotations.SerializedName

data class TopPlayer(
    @SerializedName("formattedValue")
    val formattedValue: String,
    @SerializedName("matches")
    val matches: Int,
    @SerializedName("playedEnough")
    val playedEnough: Boolean,
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team
)