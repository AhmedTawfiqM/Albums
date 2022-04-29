package com.app.albums.activity

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.app.albums.navhost.AppNavHost
import com.app.core.domain.photos.use_case.GetPhotosUseCase
import com.app.presentation.activity.AppComposeActivity
import com.app.presentation.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppComposeActivity() {

    @Composable
    override fun Content() {
        val navController = rememberNavController()
        AppNavHost(this, navController).Setup()
    }
}

