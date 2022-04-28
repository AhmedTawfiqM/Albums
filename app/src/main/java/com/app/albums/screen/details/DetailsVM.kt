package com.app.albums.screen.details

import androidx.lifecycle.SavedStateHandle
import com.app.data.data_manager.DataManager
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsVM @Inject constructor(
    private val dm: DataManager,
    private val savedStateHandle: SavedStateHandle,
) :
    AppViewModel() {
}