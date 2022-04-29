package com.app.data.api.users

import com.app.core.domain.users.repository.UserRepository
import com.app.core.domain.users.model.UserDto
import com.app.data.api.users.source.LocalUsersDataSrc
import com.app.data.api.users.source.RemoteUsersDataSrc
import retrofit2.Response

class UsersRepositoryImpl(
    private val remoteDataSrc: RemoteUsersDataSrc,
    private val localDataSrc: LocalUsersDataSrc,
) : UserRepository {
    override suspend fun getUsers(): Response<List<UserDto>> {
        return remoteDataSrc.getUsers()
    }
}