package com.app.data.api.users.source

import com.app.core.domain.users.model.UserDto
import com.app.core.domain.users.source.UsersDataSource
import retrofit2.Response

class LocalUsersDataSrc : UsersDataSource {
    override suspend fun getUsers(): Response<List<UserDto>> {
        //TODO: implement
        return Response.success(emptyList())
    }
}