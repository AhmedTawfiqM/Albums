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
        coroutineScope: CoroutineScope,
        execute: suspend () -> Response<T>,
        completion: (T) -> Unit,
    ) {
        presenter.showLoading()

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

            presenter.hideLoading()
        }
    }

    private suspend fun <T : Any> callApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(body)
            } else {
                NetworkResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            NetworkResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }

}