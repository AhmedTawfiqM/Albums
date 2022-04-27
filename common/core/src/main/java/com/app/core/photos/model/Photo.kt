package com.app.core.photos.model

import com.google.gson.annotations.SerializedName

data class Photo(
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