package com.app.albums.screen.albums_details

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.app.albums.navhost.NavHostArgument
import com.app.core.domain.albums.model.Album
import com.app.core.domain.photos.model.Photo
import com.app.core.domain.photos.model.PhotoDtoMapper
import com.app.core.domain.photos.use_case.GetPhotosUseCase
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumDetailsVM @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : AppViewModel() {

    var album: Album = NavHostArgument.getValue()
    var photos = SnapshotStateList<Photo>()
    var searchTV = mutableStateOf("")

    var filteredPhotos = SnapshotStateList<Photo>()
    //TODO: Inject Mapper
    private val photoDtoMapper = PhotoDtoMapper()

    fun fetchPhotos(albumId: Int) {
        request(execute = {
            getPhotosUseCase.invoke(albumId)
        }) {
            if (it.isNullOrEmpty()) {
                //TODO: show error
                return@request
            }
            photos.clear()
            photos.addAll(photoDtoMapper.mapList(it))
            filteredPhotos.addAll(photos)
        }
    }

    fun onSearchQuery(query: String) {
        if (query.isEmpty()) {
            filteredPhotos.clear()
            filteredPhotos.addAll(photos)
            return
        }

        val filterPhotos = photos.filter {
            it.title.contains(query)
        }

        if (filterPhotos.isNotEmpty()) {
            filteredPhotos.clear()
            filteredPhotos.addAll(filterPhotos)
        }
    }
}