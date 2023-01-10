package com.footstone22.service

import com.footstone22.helper.Contants
import com.footstone22.model.Football
import com.footstone22.model.FootballItem
import com.footstone22.model.Player
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Contants.END_POİNT)
    suspend fun getAllFootballPlayerService(): Response<Football>
}