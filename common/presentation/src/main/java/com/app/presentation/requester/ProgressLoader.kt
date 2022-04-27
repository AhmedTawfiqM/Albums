package com.app.presentation.requester

import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.FragmentActivity

class ProgressLoader(activity: FragmentActivity) {

    private val progressBar = ProgressBar(activity)

    fun show() {
        progressBar.visibility = View.VISIBLE
    }

    fun hide() {
        progressBar.visibility = View.GONE
    }
}