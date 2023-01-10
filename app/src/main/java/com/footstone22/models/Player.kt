package com.footstone22.models


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("slug")
    val slug: String
)