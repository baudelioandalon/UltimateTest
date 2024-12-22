package com.boreal.ultimatetest.rickandmorty.di


import com.boreal.ultimatetest.rickandmorty.modules.episodes.data.DefaultEpisodesRepository
import com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.interfaces.CharactersRepository
import com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.interfaces.EpisodesRepository
import com.boreal.ultimatetest.rickandmorty.modules.home.data.DefaultCharactersRepository
import com.boreal.ultimatetest.rickandmorty.modules.locations.data.DefaultLocationsRepository
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.interfaces.LocationsRepository
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


    @Binds
    abstract fun bindEpisodesRepository(
        defaultEpisodesRepository: DefaultEpisodesRepository
    ): EpisodesRepository
}