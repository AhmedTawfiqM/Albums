package com.app.presentation.requester

data class RequestOptions(
    val cancellable: Boolean
) {

    companion object{
        fun default(): RequestOptions {
            return RequestOptions(
                cancellable = true
            )
        }
    }

}