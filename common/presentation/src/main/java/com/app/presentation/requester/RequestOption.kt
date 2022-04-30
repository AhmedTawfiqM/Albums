package com.app.presentation.requester

data class RequestOption(
    var showLoading: Boolean = true,
    var inlineErrorHandling: ((Throwable) -> Boolean)? = null
) {
    companion object {
        fun defaultOption(): RequestOption {
            return RequestOption()
        }
        fun create(builder: RequestOption.() -> Unit): RequestOption {
            return RequestOption().apply(builder)
        }
    }
}