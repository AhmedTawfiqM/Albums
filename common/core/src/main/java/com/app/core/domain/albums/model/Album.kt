package com.app.core.domain.albums.model

data class Album(
    var id: Int,
    var userId: Int? = null,
    var title: String? = null,
    var body: String? = null
)
