package com.sanmed.modelviewintent.di

import com.sanmed.modelviewintent.data.DataRepositoryImp
import com.sanmed.modelviewintent.domain.DataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDataRepository(
        weatherRepositoryImpl: DataRepositoryImp
    ): DataRepository
}
