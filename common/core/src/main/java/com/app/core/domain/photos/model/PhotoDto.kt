package com.app.core.domain.photos.model

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("albumId")
    var albumId: Int? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String? = null
)