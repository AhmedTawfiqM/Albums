package com.app.albums.navhost

import com.google.gson.Gson

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