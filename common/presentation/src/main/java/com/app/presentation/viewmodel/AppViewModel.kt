package com.app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.presentation.app.CoreApp
import com.app.presentation.requester.CoroutinesRequester
import com.app.presentation.requester.Presenter
import com.app.presentation.showToast
import retrofit2.Response

open class AppViewModel : ViewModel() {

    var loading = MutableLiveData(false)

    private val coroutinesRequester by lazy {
        CoroutinesRequester(object : Presenter {
            override fun showLoading() {
                loading.value = true
            }

            override fun hideLoading() {
                loading.value = false
            }

            override fun showError(ex: Throwable) {
                showToast(CoreApp.context, ex.message ?: return)
            }

            override fun showError(msg: String?) {
                showToast(CoreApp.context, msg ?: return)
            }
        })
    }

    fun <T : Any> request(
        execute: suspend () -> Response<T>,
        completion: (T) -> Unit,
    ) {
        coroutinesRequester.request(
            coroutineScope = viewModelScope,
            execute = { execute() }
        ) {
            completion(it)
        }
    }

}