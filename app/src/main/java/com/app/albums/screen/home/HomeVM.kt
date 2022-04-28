package com.app.albums.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.app.albums.shared.di.TmpAlbumsRepo
import com.app.data.data_manager.DataManager
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val state: SavedStateHandle,
) : AppViewModel() {
    val tmpAlbumsRepository = TmpAlbumsRepo
    val testState = mutableStateOf("TestVM")
}