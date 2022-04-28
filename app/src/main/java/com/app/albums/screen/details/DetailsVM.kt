package com.app.albums.screen.details

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import com.app.albums.shared.di.TmpPhotosRepo
import com.app.albums.shared.di.TmpUsersRepo
import com.app.core.domain.photos.model.Photo
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsVM @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : AppViewModel() {

    var photos = SnapshotStateList<Photo>()

    init {
        fetchPhotos()
    }

    private fun fetchPhotos() {
        request(execute = {
            TmpPhotosRepo.photosRepo.getPhotos()
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