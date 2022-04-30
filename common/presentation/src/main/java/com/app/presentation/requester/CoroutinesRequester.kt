package com.app.presentation.requester

import com.app.core.utils.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response


class CoroutinesRequester(
    private val presenter: Presenter
) {

    //TODO: add options isloading , inlineError
    fun <T : Any> request(
        options: RequestOption = RequestOption.defaultOption(),
        coroutineScope: CoroutineScope,
        execute: suspend () -> Response<T>,
        completion: (T) -> Unit,
    ) {
        toggleLoading(options, toggleLoading = true)

        coroutineScope.launch {
            when (val response = callApi(execute = execute)) {
                is NetworkResult.Error -> {
                    presenter.showError(response.message)
                }
                is NetworkResult.Exception -> {
                    presenter.showError(response.e)
                }
                is NetworkResult.Success -> completion(response.data)
            }

            toggleLoading(options, toggleLoading = false)
        }
    }

    private fun toggleLoading(
        options: RequestOption,
        toggleLoading: Boolean
    ) {
        if (!options.showLoading)
            return

        when (toggleLoading) {
            true -> presenter.showLoading()
            false -> presenter.hideLoading()
        }
    }

    private suspend fun <T : Any> callApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            val body = response.body()

            if (response.isSuccessful && body != null) {
                return NetworkResult.Success(body)
            }
            return NetworkResult.Error(code = response.code(), message = response.message())

        } catch (e: HttpException) {
            NetworkResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }

}