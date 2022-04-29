package com.app.core.domain.users.use_case

import com.app.core.domain.users.model.UserDto
import com.app.core.domain.users.repository.UserRepository
import retrofit2.Response

class GetUsersUseCase(private val repository: UserRepository) {

    suspend fun invoke(): Response<List<UserDto>> {
        return repository.getUsers()
    }
}