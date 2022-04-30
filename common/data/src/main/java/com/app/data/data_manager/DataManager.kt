package com.app.data.data_manager

import com.app.data.api.albums.AlbumsRepositoryImpl
import com.app.data.api.photos.PhotosRepositoryImpl
import com.app.data.api.users.UsersRepositoryImpl

data class DataManager(
    //val sharedPref: SharedPref //TODO: create SharedPref
    val usersRepo: UsersRepositoryImpl,
    val albumsRepo: AlbumsRepositoryImpl,
    val photosRepo: PhotosRepositoryImpl
)