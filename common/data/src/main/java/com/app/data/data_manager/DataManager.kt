package com.app.data.data_manager

import com.app.data.api.albums.AlbumsRepositoryImpl
import com.app.data.api.photos.PhotosRepositoryImpl

data class DataManager(
    //val sharedPref: SharedPref //TODO: inject SharedPref
    val albumsRepo: AlbumsRepositoryImpl,
    val photosRepo: PhotosRepositoryImpl
)