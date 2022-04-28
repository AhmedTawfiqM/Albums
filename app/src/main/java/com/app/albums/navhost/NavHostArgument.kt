package com.app.albums.navhost

import com.google.gson.Gson

/**
this class is Responsible to has data between Nav Screens.
The problem with navigation compose is having magic strings in Route
and not Reliable to pass Parcelable Objects
 **/

object NavHostArgument {
    var value: String = ""
    val gson by lazy { Gson() }

    inline fun <reified T> setValue(param: T) {
        value = gson.toJson(param)
    }

    inline fun <reified T> getValue(): T {
        return gson.fromJson(value, T::class.java)
    }

    fun clear() {
        value = ""
    }
}