package com.app.presentation.loader

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable

class LoaderDialog  : AppDialogFragment() {

    @Composable
    override fun Content() {
        CircularProgressIndicator()
    }

}