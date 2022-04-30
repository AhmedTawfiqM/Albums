package com.app.data.api.users.source

import com.app.core.domain.users.model.UserDto
import com.app.core.domain.users.source.UsersDataSource
import com.app.data.api.users.UsersApi
import retrofit2.Response

class RemoteUsersDataSrc(val api: UsersApi) : UsersDataSource {
    override suspend fun getUsers(): Response<List<UserDto>> {
        return api.getUsers()
    }
}