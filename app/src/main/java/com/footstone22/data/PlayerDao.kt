package com.footstone22.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.footstone22.model.LocalFootbalItem
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(localFootbalItem: MutableList<LocalFootbalItem>)

    @Query("SELECT * FROM playerinfo")
    fun getSavedPlayer(): Flow<List<LocalFootbalItem>>
}