package com.app.presentation.requester

import com.app.presentation.requester.flow.FlowRequester
import com.app.presentation.requester.flow.Resource
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class CoroutinesRequester(
    private val presenter: Presenter,
) {

    suspend fun <T> request(
        requestType: RequestType,
        requestOptions: RequestOptions,
        context: CoroutineContext,
        call: suspend () -> T
    ): T? {

        return when (requestType) {
            RequestType.Deferred -> requestWithDeferred(context, call)
            RequestType.Flow -> requestWithDeferred(context, call)
        }
    }

    private suspend fun <T> requestWithDeferred(
        context: CoroutineContext,
        call: suspend () -> T
    ): T? {

        presenter.showLoading()
        val job = coroutineScope {
            async(context) {
                call
            }
        }
        val result = job.await()
        job.cancel()

        presenter.hideLoading()
        return result()
    }

    @InternalCoroutinesApi
    suspend fun <T>requestWithFlow(
        call: suspend () -> T
    ): MutableStateFlow<Resource<T>> {

        val flowRequester = FlowRequester<T>(presenter)
        flowRequester.request(call = call)
        return flowRequester.result
    }
}