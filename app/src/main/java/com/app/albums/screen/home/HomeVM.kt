package com.app.albums.screen.home

import androidx.compose.runtime.mutableStateOf
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor() :
    AppViewModel() {

    val testState = mutableStateOf("TestVM")
}