package com.app.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.app.albums.screens.ui.theme.AlbumsTheme

//TODO: implement
abstract class AppComposeActivity : ComponentActivity() {

    @Composable
    abstract fun Content()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlbumsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Content()
                }
            }
        }

    }
}