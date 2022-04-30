package com.app.core.domain.albums.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    var id: Int,
    var userId: Int? = null,
    var title: String,
    var body: String? = null
) : Parcelable
