package com.app.albums.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.app.albums.shared.di.TmpUsersRepo
import com.app.core.domain.users.model.User
import com.app.core.utils.NetworkResult
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val state: SavedStateHandle, //TODO: remove
) : AppViewModel() {

    var currentUser: User? by mutableStateOf(null)
    var users = SnapshotStateList<User>()

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            val response = callApi {
                TmpUsersRepo.usersRepo.getUsers()
            }
            when (response) {
                is NetworkResult.Error,
                is NetworkResult.Exception -> Log.e("fetchUsers", "fetchUsers: ")
                is NetworkResult.Success -> {
                    users.addAll(response.data)
                    currentUser = users[0]
                }
            }

        }
    }
}