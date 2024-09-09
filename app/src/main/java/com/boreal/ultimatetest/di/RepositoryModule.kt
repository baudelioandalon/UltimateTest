package com.boreal.ultimatetest.di

import com.boreal.ultimatetest.modules.home.data.DefaultCharactersRepository
import com.boreal.ultimatetest.modules.home.domain.interfaces.CharactersRepository
import com.boreal.ultimatetest.modules.locations.data.DefaultLocationsRepository
import com.boreal.ultimatetest.modules.locations.domain.interfaces.LocationsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharactersRepository(
        defaultCharactersRepository: DefaultCharactersRepository
    ): CharactersRepository

    @Binds
    abstract fun bindLocationsRepository(
        defaultLocationsRepository: DefaultLocationsRepository
    ): LocationsRepository
}