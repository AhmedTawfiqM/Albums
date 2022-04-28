package com.app.core.domain.users

import com.app.core.domain.users.model.UserDto
import retrofit2.Response

interface UserRepository {
    suspend fun getUsers(): Response<List<UserDto>>
}