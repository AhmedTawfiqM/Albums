package com.app.core.domain.photos.model

import com.app.core.utils.Mapper

class PhotoDtoMapper : Mapper<PhotoDto,Photo> {

    override fun map(model: PhotoDto): Photo {
        return Photo(
            albumId = model.albumId,
            id = model.id,
            title = model.title,
            url = model.url,
            thumbnailUrl = model.thumbnailUrl,
        )
    }
}