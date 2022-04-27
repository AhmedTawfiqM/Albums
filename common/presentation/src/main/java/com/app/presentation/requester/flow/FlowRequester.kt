package com.app.presentation.requester.flow

import com.app.presentation.requester.Presenter
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import retrofit2.Response

class FlowRequester<T>(private val presenter: Presenter) {

    var result: MutableStateFlow<Resource<T>> =
        MutableStateFlow(Resource.Loading)

    @InternalCoroutinesApi
    suspend fun request(call: suspend () -> T) {
        presenter.showLoading()

        val callFlow = flow<T> {
            call()
        }
        callFlow.catch { ex ->
            result.value = Resource.Error(ex)
        }.collect {
            val response = it
            result.value = Resource.Success(response)
        }

        result.collect {
            presenter.hideLoading()
            when (it) {
                is Resource.Error -> {
                    handleError(it)
                }
                is Resource.Success -> {
                }
                Resource.Loading -> {
                }
            }
        }
    }

    private fun handleError(ex: Resource.Error) {
        presenter.showError(ex.exception)
        val message = ex.exception.message ?: return
        presenter.showError(message)
    }
}
