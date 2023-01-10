package com.footstone22.utils

import dagger.hilt.android.AndroidEntryPoint


class CraftHelper {
    companion object {
        var selectedNumberList= arrayListOf<Int>()
        fun clear(){
            selectedNumberList= arrayListOf()
        }
    }

}