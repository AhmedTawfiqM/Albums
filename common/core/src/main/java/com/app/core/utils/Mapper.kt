package com.app.core.utils

interface Mapper<IN, OUT> {

    fun map(model: IN): OUT

    fun mapList(list: List<IN>): List<OUT> {
        return list.map {
            map(it)
        }
    }
}