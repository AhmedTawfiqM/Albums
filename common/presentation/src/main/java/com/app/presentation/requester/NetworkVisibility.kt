package com.app.presentation.requester

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

class NetworkVisibility {

    init {
        
    }
    companion object {

        //TODO: remove Deprecation
        @SuppressLint("MissingPermission")
        fun isAvailable(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }
    }

}