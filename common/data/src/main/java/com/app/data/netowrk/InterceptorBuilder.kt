package com.app.data.netowrk

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorBuilder(private val tokenInterceptor: Interceptor?=null) {

    fun build(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)

        if (tokenInterceptor != null)
            builder.addInterceptor(tokenInterceptor)

        return builder.build()
    }
}