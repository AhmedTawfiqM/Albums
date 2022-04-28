package com.app.core.domain.albums.model

import com.app.core.utils.Mapper

class AlbumDtoMapper : Mapper<AlbumDto, Album> {

    override fun map(model: AlbumDto): Album {
        return Album(
            id = model.id,
            userId = model.userId,
            title = model.title,
            body = model.body,
        )
    }

}