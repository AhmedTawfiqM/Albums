package com.app.albums.shared.di.domain

import com.app.albums.shared.di.TmpAlbumsRepo
import com.app.data.api.albums.AlbumsApi
import com.app.data.api.albums.AlbumsRepositoryImpl
import com.app.data.api.albums.source.LocalAlbumsDataSrc
import com.app.data.api.albums.source.RemoteAlbumsDataSrc
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

//    @Singleton
//    @Provides
//    fun provideAlbumsRepository(api: AlbumsApi): AlbumsRepositoryImpl {
//         val remoteAlbumsDataSrc = RemoteAlbumsDataSrc(TmpAlbumsRepo.albumsApi)
//         val localAlbumsDataSrc = LocalAlbumsDataSrc()
//        return AlbumsRepositoryImpl(api)
//    }
}