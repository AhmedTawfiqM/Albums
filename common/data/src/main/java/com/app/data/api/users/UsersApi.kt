package com.app.data.api.users

import com.app.core.domain.users.model.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface UsersApi {
    @GET("users")
    suspend fun getUsers(): Response<List<UserDto>>
}