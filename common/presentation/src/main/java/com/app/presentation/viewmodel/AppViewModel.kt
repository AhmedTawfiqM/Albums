package com.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.app.core.utils.NetworkResult
import com.app.data.data_manager.DataManager
import retrofit2.HttpException
import retrofit2.Response

open class AppViewModel(val dm: DataManager) : ViewModel() {


    suspend fun <T : Any> request(
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