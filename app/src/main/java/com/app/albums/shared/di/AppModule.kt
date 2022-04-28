package com.app.albums.shared.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //TODO: to be removed
    @Provides
    @Singleton
    fun provideTestString(): String = "test String"
}