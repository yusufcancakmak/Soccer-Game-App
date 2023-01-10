package com.footstone22.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.footstone22.model.LocalFootbalItem
import com.footstone22.model.Player

@Database(entities = [LocalFootbalItem::class], version = 1)
@TypeConverters(PlayerTypeConverter::class)
abstract class PlayerDatabasae:RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}