package com.footstone22.data

import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters
class PlayerTypeConverter {

    @TypeConverter
    fun fromAnyToString(attribute :Any?):String{
        if (attribute ==null)
            return ""
        return attribute as String
    }

    @TypeConverter
    fun fromStringToAny(attribute:String?):Any{
        if (attribute ==null)
            return ""
        return attribute
    }
}