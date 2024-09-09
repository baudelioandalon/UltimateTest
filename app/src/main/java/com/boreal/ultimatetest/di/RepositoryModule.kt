package com.boreal.ultimatetest.di

import com.boreal.ultimatetest.modules.home.data.DefaultRickAndMortyRepository
import com.boreal.ultimatetest.modules.home.domain.interfaces.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRickAndMortyRepository(
        defaultRickAndMortyRepository: DefaultRickAndMortyRepository
    ): RickAndMortyRepository
}