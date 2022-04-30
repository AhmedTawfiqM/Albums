package com.app.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.presentation.app.CoreApp
import com.app.presentation.requester.CoroutinesRequester
import com.app.presentation.requester.Presenter
import com.app.presentation.showToast
import retrofit2.Response

open class AppViewModel : ViewModel() {

    var toggleLoading = mutableStateOf(false)
    var showError = MutableLiveData("")

    init {
        showError.observeForever {
            if (it.isEmpty()) return@observeForever
            showToast(CoreApp.context, it)
        }
    }

    private val coroutinesRequester by lazy {
        CoroutinesRequester(object : Presenter {
            override fun showLoading() {
                toggleLoading.value = true
            }

            override fun hideLoading() {
                toggleLoading.value = false
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