package com.app.data

import com.app.data.tmp.FakeResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface MockCall {

    @GET("78c1974f-9c6f-4d52-8193-d484aa099753")
    suspend fun getData(): Response<FakeResponse>

    @GET("78c1974f-9c6f-4d52-8193-d484aa099753")
    suspend fun getGlory(): Response<FakeResponse>
}