package com.app.albums.activity

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.app.albums.navhost.AlbumsNavHost
import com.app.albums.navhost.factory.NavControllerHostFactory
import com.app.albums.navhost.factory.NavHostType
import com.app.presentation.activity.AppComposeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppComposeActivity() {

    @Composable
    override fun Content() {
        val navController = rememberNavController()
        AlbumsNavHost(this, navController).Setup()
    }

    //This Option is The Best Practice With Complex Projects
    @Composable
    fun NavHostContent() {
        val navHostConFactory = NavControllerHostFactory(this)
        val navHost = navHostConFactory.create(type = NavHostType.Albums)
        navHost.Setup()
    }
}

