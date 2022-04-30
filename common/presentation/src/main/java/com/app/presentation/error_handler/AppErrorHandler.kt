package com.app.presentation.error_handler

import com.app.presentation.showToast

class AppErrorHandler {

    fun showError(msg: String) {
        showToast(value = msg)
    }
}