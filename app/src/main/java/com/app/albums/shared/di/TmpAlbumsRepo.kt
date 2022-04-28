package com.app.albums.shared.di

import com.app.data.BuildConfig
import com.app.data.api.albums.AlbumsApi
import com.app.data.api.albums.AlbumsRepositoryImpl
import com.app.data.netowrk.RetrofitHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object TmpAlbumsRepo {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val albumsApi: AlbumsApi = RetrofitHelper.buildRetrofit(
        baseUrl = BuildConfig.API_BASE_URL,
        client = okHttpClient,
    ).create(AlbumsApi::class.java)
    val albumsRepositoryImpl = AlbumsRepositoryImpl(albumsApi)
}