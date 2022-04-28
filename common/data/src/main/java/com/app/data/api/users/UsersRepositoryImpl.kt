package com.app.data.api.users

import com.app.core.domain.users.UserRepository
import com.app.core.domain.users.model.UserDto
import retrofit2.Response

class UsersRepositoryImpl(private val api: UsersApi) : UserRepository {
    override suspend fun getUsers(): Response<List<UserDto>> {
        return api.getUsers()
    }
}