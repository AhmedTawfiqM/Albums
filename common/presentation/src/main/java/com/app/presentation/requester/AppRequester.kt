package com.app.presentation.requester

import androidx.fragment.app.FragmentActivity
import com.app.presentation.requester.flow.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class AppRequester(activity: FragmentActivity) {

    private val progressLoading = ProgressLoader(activity)

    private val requester by lazy {

        val presenter = object : Presenter {
            override fun showLoading() {
                progressLoading.show()
            }

            override fun hideLoading() {
                progressLoading.hide()
            }

            override fun showError(ex: Throwable) {
            }

            override fun showError(msg: String) {
            }

        }

        CoroutinesRequester(presenter)
    }

    suspend fun <T> request(
        requestType: RequestType = RequestType.Deferred,
        requestOptions: RequestOptions = RequestOptions.default(),
        context: CoroutineContext = Dispatchers.IO,
        call: suspend () -> T
    ){
        requester.request(
            requestType, requestOptions, context, call
        )
    }

    @InternalCoroutinesApi
    suspend fun <T>requestWithFlow(
        call: suspend () -> Response<T>
    ): MutableStateFlow<Resource<Any>> {
        return requester.requestWithFlow(call)
    }

}