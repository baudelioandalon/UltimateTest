package com.boreal.ultimatetest.core.domain.base

import android.util.Log

/**
 * Extension function to log a string
 */
fun String.log(key: String, error: Boolean = true){
    if(!error){
        Log.i(key,this)
    }else{
        Log.e(key,this)
    }
}