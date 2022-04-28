package com.app.albums.shared.di

import com.app.data.BuildConfig
import com.app.data.api.albums.AlbumsApi
import com.app.data.api.albums.AlbumsRepositoryImpl
import com.app.data.api.users.UsersRepositoryImpl
import com.app.data.api.users.UsersApi
import com.app.data.netowrk.RetrofitHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}
private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()

object TmpUsersRepo {
    private val usersApi = RetrofitHelper.buildRetrofit(
        baseUrl = BuildConfig.API_BASE_URL,
        client = okHttpClient,
    ).create(UsersApi::class.java)
    val usersRepo = UsersRepositoryImpl(usersApi)
}

object TmpAlbumsRepo {
    private val albumsApi: AlbumsApi = RetrofitHelper.buildRetrofit(
        baseUrl = BuildConfig.API_BASE_URL,
        client = okHttpClient,
    ).create(AlbumsApi::class.java)
    val albumsRepo = AlbumsRepositoryImpl(albumsApi)
}