package com.app.albums.screen.albums

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
import com.app.albums.navhost.Screen
import com.app.albums.screen.albums.view.AlbumsListView
import com.app.core.domain.albums.model.Album
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.NavControllerHost
import com.app.presentation.activity.screen.argument.NavHostArgument
import com.app.presentation.activity.screen.builder.createVM

class AlbumsScreen(
    override val host: NavControllerHost
) : AppScreen<AlbumsVM>() {

    override val vm: AlbumsVM = createVM()

    @Composable
    override fun Content() {
        LoadData()

        Column(modifier = Modifier.padding(10.dp)) {
            ProfileTextView()
            UserDetailsView()
            MyAlbumsTextView()

            AlbumsListView(vm.albums).Content {
                onAlbumClick(it)
            }
        }
    }

    @Composable
    private fun LoadData() {
        LaunchedEffect(true) {
            vm.fetchUsers {
                vm.fetchAlbums()
            }
        }
    }

    @Composable
    private fun MyAlbumsTextView() {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "My Albums", //TODO : localize
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
    }

    @Composable
    private fun UserDetailsView() {
        if (vm.currentUser == null) return
        Column {
            Text(
                text = vm.currentUser!!.name,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = vm.userAddressDetails,
                color = Color.Black,
                fontSize = 15.sp
            )
        }
    }

    @Composable
    private fun ProfileTextView() {
        Text(
            text = "Profile", //TODO : localize
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
    }

    private fun onAlbumClick(album: Album) {
        NavHostArgument.setValue(album)
        navigate(Screen.AlbumDetails)
    }
}