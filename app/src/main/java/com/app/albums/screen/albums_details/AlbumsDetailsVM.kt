package com.app.albums.screen.albums_details

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import com.app.albums.shared.di.TmpPhotosRepo
import com.app.core.domain.photos.model.PhotoDto
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumsDetailsVM @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : AppViewModel() {

    var photos = SnapshotStateList<PhotoDto>()

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