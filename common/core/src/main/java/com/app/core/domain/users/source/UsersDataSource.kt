package com.app.core.domain.users.source

import com.app.core.domain.users.model.UserDto
import retrofit2.Response

interface UsersDataSource {
    suspend fun getUsers(): Response<List<UserDto>>
}