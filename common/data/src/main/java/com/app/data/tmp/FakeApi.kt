package com.app.data.tmp

import com.app.data.MockCall
import com.app.data.netowrk.InterceptorBuilder
import com.app.data.netowrk.RetrofitHelper

object FakeApi {

    private val interceptorBuilder = InterceptorBuilder()

    val api =   RetrofitHelper.createService(
        "https://mocki.io/v1/",
        interceptorBuilder.build(),
        MockCall::class.java
    )
}