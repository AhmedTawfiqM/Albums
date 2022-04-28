package com.app.core.domain.users

import com.app.core.domain.users.model.User
import retrofit2.Response

interface UserRepository {
    fun getUsers(): Response<List<User>>
}