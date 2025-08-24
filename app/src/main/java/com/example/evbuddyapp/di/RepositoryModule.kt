package com.example.evbuddyapp.di

import com.example.evbuddyapp.data.repository.DataRepository
import com.example.evbuddyapp.data.repository.DataRepositoryFake
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
        dataRepository: DataRepositoryFake
    ) : DataRepository


}