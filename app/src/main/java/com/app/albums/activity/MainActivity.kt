package com.app.albums.activity

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.albums.navhost.AppNavHost
import com.app.presentation.activity.AppComposeActivity
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppComposeActivity() {

    private lateinit var navController: NavHostController

    @Composable
    override fun Content() {
        navController = rememberNavController()
        AppNavHost(navController).Setup()
    }
}

