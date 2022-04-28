package com.app.core.domain.users.model

import com.app.core.utils.Mapper

class UserDtoMapper : Mapper<UserDto,User> {

    override fun map(model: UserDto): User {
        return User(
            id = model.id,
            name = model.name,
            username = model.username,
            email = model.email,
            website = model.website,
            address = model.address,
            phone = model.phone,
            company = model.company,
        )
    }
}