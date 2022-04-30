package com.app.albums.shared.di.domain

import com.app.core.domain.users.use_case.GetUsersUseCase
import com.app.data.api.users.UsersApi
import com.app.data.api.users.UsersRepositoryImpl
import com.app.data.api.users.source.LocalUsersDataSrc
import com.app.data.api.users.source.RemoteUsersDataSrc
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsersModule {

    @Provides
    @Singleton
    fun provideUsersApiService(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUsersRemoteDataSrc(api: UsersApi): RemoteUsersDataSrc {
        return RemoteUsersDataSrc(api)
    }

    @Singleton
    @Provides
    fun provideUsersLocalDataSrc(api: UsersApi): LocalUsersDataSrc {
        return LocalUsersDataSrc()
    }

    @Singleton
    @Provides
    fun provideUsersRepository(
        api: UsersApi,
        remoteSrc: RemoteUsersDataSrc,
        localSrc: LocalUsersDataSrc
    ): UsersRepositoryImpl {
        return UsersRepositoryImpl(remoteSrc, localSrc)
    }

    @Provides
    @Singleton
    fun provideGetUsersUseCase(repository: UsersRepositoryImpl): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }

}