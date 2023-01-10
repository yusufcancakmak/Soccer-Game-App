package com.footstone22.module

import android.app.Application
import androidx.room.Room
import com.footstone22.data.PlayerDatabasae
import com.footstone22.helper.Contants
import com.footstone22.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun BASE_URL()= Contants.BASE_URL

    @Provides
    @Singleton
    fun RetrofitInstance(): ApiService =
        Retrofit.Builder()
            .baseUrl(Contants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


    @Provides
    @Singleton
    fun providesDatabase(app:Application): PlayerDatabasae =
        Room.databaseBuilder(app, PlayerDatabasae::class.java,"player.db").build()
}