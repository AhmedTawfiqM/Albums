package com.app.core.domain.users

class GetUsersUseCase(private val repository: UserRepository) {

    suspend fun invoke() {
        repository.getUsers()
    }
}