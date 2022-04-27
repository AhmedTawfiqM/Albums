package com.app.presentation.requester

interface Presenter {
    fun showLoading()
    fun hideLoading()
    fun showError(ex: Throwable)
    fun showError(msg: String)
}