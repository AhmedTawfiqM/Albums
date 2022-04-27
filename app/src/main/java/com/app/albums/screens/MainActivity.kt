package com.app.albums.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.albums.screens.ui.theme.AlbumsTheme
import com.app.presentation.activity.AppComposeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppComposeActivity() {

    @Composable
    override fun Content() {
        DefaultPreview()
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        AlbumsTheme {
            Greeting("Android")
        }
    }
}

