package com.app.data.data_manager

data class DataManager(
    //val sharedPref: SharedPref //TODO: inject SharedPref
    val repo: Class<*> //TODO: replace with your repos
)