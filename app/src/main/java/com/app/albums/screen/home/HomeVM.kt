package com.app.albums.screen.home

import androidx.compose.runtime.mutableStateOf
import com.app.data.data_manager.DataManager
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val dataManager: DataManager
) : AppViewModel(dataManager) {

    val testState = mutableStateOf("TestVM")
}