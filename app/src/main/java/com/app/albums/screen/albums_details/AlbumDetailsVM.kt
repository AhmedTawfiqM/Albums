package com.app.albums.screen.albums_details

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import com.app.albums.shared.di.TmpPhotosRepo
import com.app.core.domain.albums.model.Album
import com.app.core.domain.photos.model.PhotoDto
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumDetailsVM @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : AppViewModel() {

    lateinit var album: Album
    var photos = SnapshotStateList<PhotoDto>()
    var searchInput = mutableStateOf("")

    fun fetchPhotos(albumId: Int) {
        request(execute = {
            TmpPhotosRepo.photosRepo.getPhotos(albumId)
        }) {
            if (it.isNullOrEmpty()) {
                //TODO: show error
                return@request
            }
            photos.clear()
            photos.addAll(it)
        }
    }
}