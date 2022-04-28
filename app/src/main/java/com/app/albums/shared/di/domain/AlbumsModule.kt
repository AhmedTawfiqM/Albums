package com.app.albums.shared.di.domain

import com.app.core.albums.AlbumsRepository
import com.app.data.api.albums.AlbumsApi
import com.app.data.api.albums.AlbumsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlbumsModule {

    //TODO: add DataSrc class

    @Provides
    @Singleton
    fun provideAlbumsApiService(retrofit: Retrofit): AlbumsApi {
        return retrofit.create(AlbumsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAlbumsRepository(api: AlbumsApi): AlbumsRepository {
        return AlbumsRepositoryImpl(api)
    }
}