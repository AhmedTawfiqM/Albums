package com.app.albums.activity

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.app.albums.navhost.AppNavHost
import com.app.presentation.activity.AppComposeActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppComposeActivity() {

    @Inject
    lateinit var testString: String

    @ExperimentalFoundationApi
    @Composable
    override fun Content() {
        val navController = rememberNavController()
        AppNavHost(this, navController).Setup()
    }
}

