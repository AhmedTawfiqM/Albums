package com.app.data.netowrk

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("appid", "hello")
            .addHeader("deviceplatform", "android")
            .removeHeader("User-Agent")
            .addHeader("User-Agent", "Mozilla/5.0.....")
            .build()
        return chain.proceed(request)
    }
}