package com.footstone22.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.footstone22.repository.FootbalPlayerResponse
import com.footstone22.model.FootballItem
import com.footstone22.model.LocalFootbalItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FootballPlayerViewModel @Inject constructor(private val repository: FootbalPlayerResponse) :ViewModel(){

    private val _getfootbalplayerLiveData=MutableLiveData<List<FootballItem>>()

    val getfootballist: LiveData<List<FootballItem>> =_getfootbalplayerLiveData


    fun getallplayerviewModel()=
        viewModelScope.launch {
            val response=repository.GetAllFootballPlayer().let {
                response ->
                if (response.isSuccessful){
                    _getfootbalplayerLiveData.postValue(response.body())
                }else{
                    Log.d("testApp",response.message().toString())
                }
            }

        }
    fun insertPlayer(localFootbalItem: MutableList<LocalFootbalItem>)=viewModelScope.launch {
        repository.insertPlayer(localFootbalItem)
    }
    fun getSavedPlayer()=repository.getPlayerSaved
    }
