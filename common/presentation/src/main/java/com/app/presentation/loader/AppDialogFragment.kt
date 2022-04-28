package com.app.presentation.loader

import android.os.Bundle
import android.view.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.app.albums.screen.ui.theme.AppTheme

abstract class AppDialogFragment : DialogFragment() {

    @Composable
    abstract fun Content()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    this@AppDialogFragment.Content()
                }
            }
        }
    }

    fun show(manager: FragmentManager) {
        super.show(manager, AppDialogFragment::class.java.name)
    }
}