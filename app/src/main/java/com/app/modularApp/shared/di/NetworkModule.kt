package com.app.modularApp.shared.di

import com.app.data.BuildConfig
import com.app.data.domain.AlbumsApi
import com.app.data.netowrk.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        if (!BuildConfig.DEBUG) {
            return OkHttpClient
                .Builder()
                .build()
        }
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitHelper.buildRetrofit(
            baseUrl = BuildConfig.LIBRARY_PACKAGE_NAME, //TODO: add Base Url
            okHttpClient,
        )
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): AlbumsApi {
        return retrofit.create(AlbumsApi::class.java)
    }

}