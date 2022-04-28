package com.app.data.data_manager

import com.app.core.albums.AlbumsRepository
import com.app.core.photos.PhotosRepository

data class DataManager(
    //val sharedPref: SharedPref //TODO: inject SharedPref
    val albumsRepo: AlbumsRepository,
    val photosRepo: PhotosRepository
)