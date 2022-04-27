package com.app.presentation.requester

interface Requester<T> {
    fun request(): T
}