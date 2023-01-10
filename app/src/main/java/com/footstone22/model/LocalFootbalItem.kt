package com.footstone22.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "playerinfo")
data class LocalFootbalItem (
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var platerId:Int,
    var name: String,
    var matches: Int,
    var formattedValue: String,
    var imageviewurl:String
    )