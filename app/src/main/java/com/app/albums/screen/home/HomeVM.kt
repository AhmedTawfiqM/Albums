package com.app.albums.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import com.app.data.data_manager.DataManager
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val dm: DataManager
) : AppViewModel() {

    val testState = mutableStateOf("TestVM")
}