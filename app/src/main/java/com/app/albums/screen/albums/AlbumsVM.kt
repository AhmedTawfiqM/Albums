package com.app.albums.screen.albums

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import com.app.albums.shared.di.TmpAlbumsRepo
import com.app.albums.shared.di.TmpUsersRepo
import com.app.core.domain.albums.model.Album
import com.app.core.domain.albums.model.AlbumDtoMapper
import com.app.core.domain.albums.use_case.GetAlbumsUseCase
import com.app.core.domain.photos.use_case.GetPhotosUseCase
import com.app.core.domain.users.model.User
import com.app.core.domain.users.model.UserDto
import com.app.core.domain.users.model.UserDtoMapper
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumsVM @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
) : AppViewModel() {

    var currentUser: User? by mutableStateOf(null)
    private var users = SnapshotStateList<User>()

    var albums = SnapshotStateList<Album>()

    val userAddressDetails: String
        get() = currentUser?.address.run {
            if (this == null) return@run ""
            "$street, $suite, $city , ${currentUser!!.phone}"
        }

    fun fetchUsers(onSuccess: () -> Unit = {}) {
        request(execute = {
            TmpUsersRepo.usersRepo.getUsers()
        }) {
            if (it.isNullOrEmpty()) {
                //TODO: show error
                return@request
            }
            //TODO: Inject Mapper
            users.clear()
            users.addAll(UserDtoMapper().mapList(it))
            currentUser = users.random()

            onSuccess()
        }
    }

    //TODO: inject mappers
    fun fetchAlbums() {
        val userId = currentUser?.id ?: return
        request(execute = {
            getAlbumsUseCase.invoke(userId)
        }) {
            if (it.isNullOrEmpty()) {
                //TODO: show error
                return@request
            }
            albums.clear()
            albums.addAll(AlbumDtoMapper().mapList(it))
        }
    }
}