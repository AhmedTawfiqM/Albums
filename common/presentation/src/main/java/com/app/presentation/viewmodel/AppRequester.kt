package com.app.presentation.viewmodel

import com.app.presentation.requester.CoroutinesRequester
import com.app.presentation.requester.Presenter

class AppRequester {

    val coroutinesRequester by lazy {
        CoroutinesRequester(object : Presenter {
            override fun showLoading() {

            }

            override fun hideLoading() {

            }

            override fun showError(ex: Throwable) {

            }

            override fun showError(msg: String?) {

            }
        })
    }
}