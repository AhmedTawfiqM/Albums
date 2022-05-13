package com.app.albums.screen.albums

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.app.core.domain.albums.model.Album
import com.app.core.domain.albums.model.AlbumDtoMapper
import com.app.core.domain.albums.use_case.GetAlbumsUseCase
import com.app.core.domain.users.model.User
import com.app.core.domain.users.model.UserDtoMapper
import com.app.core.domain.users.use_case.GetUsersUseCase
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumsVM @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val getUsersUseCase: GetUsersUseCase
) : AppViewModel() {

    var currentUser: User? by mutableStateOf(null)
    private var users = SnapshotStateList<User>()

    var albums = SnapshotStateList<Album>()

    val userAddressDetails: String
        get() = currentUser?.address.run {
            if (this == null) return@run ""
            "$street, $suite, $city , ${currentUser!!.phone}"
        }

    //TODO: Inject Mappers
    private val albumsDtoMapper = AlbumDtoMapper()
    private val usersDtoMapper = UserDtoMapper()

    fun fetchUsers(onSuccess: () -> Unit = {}) {
        request(execute = {
            getUsersUseCase.invoke()
        }) {
            if (it.isNullOrEmpty()) {
                handleError("Empty or Null Users List") //TODO: localize
                return@request
            }
            users.clear()
            users.addAll(usersDtoMapper.mapList(it))
            currentUser = users.random()

            onSuccess()
        }
    }

    fun fetchAlbums() {
        val userId = currentUser?.id ?: return
        request(execute = {
            getAlbumsUseCase.invoke(userId)
        }) {
            if (it.isNullOrEmpty()) {
                handleError("Empty or Null Albums List")//TODO: localize
                return@request
            }
            albums.clear()
            albums.addAll(albumsDtoMapper.mapList(it))
        }
    }
}