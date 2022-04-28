package com.app.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.core.utils.NetworkResult
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

open class AppViewModel : ViewModel() {

    //TODO: implement loader
    val loading = mutableStateOf(false)

    fun <T : Any> request(
        execute: suspend () -> Response<T>,
        completion: (T) -> Unit,
    ) {
        viewModelScope.launch {
            when (val response = callApi(execute = execute)) {
                is NetworkResult.Error,
                is NetworkResult.Exception -> {
                    //TODO: show error
                    Log.d("NetworkResult", "request: $response")
                }
                is NetworkResult.Success -> completion(response.data)
            }
        }
    }

    //TODO: seperate to CoroutineRequester Class
    private suspend fun <T : Any> callApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(body)
            } else {
                Log.d("NetworkResult", "request: ${response.message()}")
                NetworkResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            Log.d("NetworkResult", "request: ${e.message()}")
            NetworkResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            Log.d("NetworkResult", "request: ${e.message}")
            NetworkResult.Exception(e)
        }
    }
}