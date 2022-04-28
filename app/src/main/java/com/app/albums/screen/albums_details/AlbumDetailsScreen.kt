package com.app.albums.screen.albums_details

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.albums.navhost.NavHostArgument
import com.app.core.domain.albums.model.Album
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenHost
import com.app.presentation.compose.FormTextField
import com.app.presentation.showToast

class AlbumDetailsScreen(
    override val host: ScreenHost,
) : AppScreen<AlbumDetailsVM> {

    override val vm: AlbumDetailsVM by host.activity.viewModels()

    @Composable
    override fun Content() {
        LoadPhotos()

        Column(modifier = Modifier.padding(10.dp)) {
            AlbumTitleView()
            SearchTextField()
        }
    }

    @Composable
    private fun SearchTextField() {
        FormTextField(
            state = vm.searchInput,
            color = Color.Gray
        ) {
            showToast(context(), "Changed")
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
    }

    @Composable
    private fun LoadPhotos() {
        vm.album = NavHostArgument.getValue()
        LaunchedEffect(true) {
            vm.fetchPhotos(vm.album.id)
        }
    }

}