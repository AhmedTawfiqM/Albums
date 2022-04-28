package com.app.albums.screen.albums

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.albums.navhost.NavHostArgument
import com.app.albums.navhost.Screen
import com.app.core.domain.albums.model.Album
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsScreen(
    override val host: ScreenHost
) : AppScreen<AlbumsVM> {

    //TODO: try to move 'Creation of VM' to AppScreen
    override val vm: AlbumsVM by activity().viewModels()

    @Composable
    override fun Content() {
        LoadData()

        Column {
            ProfileTextView()
            UserDetailsView()
        }
    }

    @Composable
    private fun UserDetailsView() {
        if (vm.currentUser == null) return
        Column {
            Text(
                text = vm.currentUser!!.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = vm.currentUser!!.addressDetails,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }

    @Composable
    private fun ProfileTextView() {
        Text(
            text = "Profile", //TODO : localize
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 15.sp
        )
    }

    private fun onAlbumClick() {
        NavHostArgument.setValue(Album(1))
        navigate(Screen.AlbumDetails)
    }

    @Composable
    private fun LoadData() {
        vm.fetchUsers {
            vm.fetchAlbums()
        }
    }
}