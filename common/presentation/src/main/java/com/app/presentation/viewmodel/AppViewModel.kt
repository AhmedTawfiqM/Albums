package com.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.core.domain.users.model.User
import com.app.core.utils.NetworkResult
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

open class AppViewModel : ViewModel() {

    fun <T : Any> request(
        execute: suspend () -> Response<T>,
        completion: (T) -> Unit,
        ) {
        viewModelScope.launch {
            when (val response = callApi(execute = execute)) {
                is NetworkResult.Error,
                is NetworkResult.Exception -> {
                    //TODO show error
                }
                is NetworkResult.Success -> completion(response.data)
            }
        }
    }

    //TODO: seperate to CoroutineRequester Class
    suspend fun <T : Any> callApi(
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