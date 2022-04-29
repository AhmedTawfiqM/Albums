package com.app.core.domain.users.use_case

import com.app.core.domain.users.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {

    suspend fun invoke() {
        repository.getUsers()
    }
}