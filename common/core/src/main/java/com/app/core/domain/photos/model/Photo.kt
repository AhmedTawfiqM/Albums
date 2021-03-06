package com.app.core.domain.photos.model


data class Photo(
    var albumId: Int? = null,
    var id: Int? = null,
    var title: String = "",
    var url: String? = null,
    var thumbnailUrl: String? = null
)