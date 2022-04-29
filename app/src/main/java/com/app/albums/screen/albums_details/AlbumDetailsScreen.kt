package com.app.albums.screen.albums_details

import android.R
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.albums.screen.albums_details.view.PhotosGridView
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.NavControllerHost
import com.app.presentation.compose.FormTextField
import com.app.presentation.showToast

class AlbumDetailsScreen(
    override val host: NavControllerHost,
) : AppScreen<AlbumDetailsVM>() {
    override val vm: AlbumDetailsVM by host.activity.viewModels()

    @ExperimentalFoundationApi
    @Composable
    override fun Content() {
        LoadPhotos()

        Column(modifier = Modifier.padding(10.dp)) {
            AlbumTitleView()
            SearchTextField()
            GalleryView()
        }
    }

    @ExperimentalFoundationApi
    @Composable
    private fun GalleryView() {
        PhotosGridView(vm.filteredPhotos).Content {
            showToast(context(), it.title ?: "")
        }
    }

    @Composable
    private fun LoadPhotos() {
        LaunchedEffect(true) {
            vm.fetchPhotos(vm.album.id)
        }
    }

    @Composable
    private fun SearchTextField() {
        FormTextField(
            state = vm.searchTV,
            color = Color.Gray,
            label = {
                Text(text = "Search an Image") //TODO: localize
            },
            leadingIcon = {
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.ic_menu_search),
                    contentDescription = ""
                )
            }
        ) {
            vm.onSearchQuery(it)
        }
    }

    @Composable
    private fun AlbumTitleView() {
        Text(
            text = vm.album.title,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 25.sp,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(15.dp))
        Divider(
            modifier = Modifier
                .height(1.dp)
                .alpha(0.2f),
            color = Color.Gray
        )
    }

}