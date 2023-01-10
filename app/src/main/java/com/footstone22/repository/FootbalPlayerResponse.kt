package com.footstone22.repository

import android.util.Log
import com.footstone22.data.PlayerDatabasae

import com.footstone22.service.ApiService
import com.footstone22.model.Football
import com.footstone22.model.LocalFootbalItem
import retrofit2.Response
import javax.inject.Inject

class FootbalPlayerResponse @Inject constructor(private val api: ApiService, private val db : PlayerDatabasae) {

    private val database=db.playerDao()

    suspend fun GetAllFootballPlayer(): Response<Football> {
        val response=api.getAllFootballPlayerService()
        if (response.isSuccessful){
            Log.d("testApp","Success to connected to FotballPlayer response")
            Log.d("testApp",response.code().toString())
        }else{
            Log.d("testApp","Failed to connected to FotballPlayer response")
            Log.d("testApp",response.code().toString())
        }
        return response
    }

    suspend fun insertPlayer(localFootbalItem: MutableList<LocalFootbalItem>){
        database.insert(localFootbalItem)
    }
    val getPlayerSaved=database.getSavedPlayer()
}