package com.boreal.ultimatetest.di

import com.boreal.ultimatetest.modules.episodes.domain.interfaces.EpisodesRepository
import com.boreal.ultimatetest.modules.episodes.domain.use_cases.GetListEpisodesUseCase
import com.boreal.ultimatetest.modules.episodes.domain.use_cases.GetMoreEpisodesUseCase
import com.boreal.ultimatetest.modules.home.domain.interfaces.CharactersRepository
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetListCharactersUseCase
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetMoreCharactersUseCase
import com.boreal.ultimatetest.modules.locations.domain.interfaces.LocationsRepository
import com.boreal.ultimatetest.modules.locations.domain.use_cases.GetListLocationsUseCase
import com.boreal.ultimatetest.modules.locations.domain.use_cases.GetMoreLocationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetListCharactersUseCase(charactersRepository: CharactersRepository) =
        GetListCharactersUseCase(charactersRepository)


    @Provides
    fun provideGetMoreCharactersUseCase(charactersRepository: CharactersRepository) =
        GetMoreCharactersUseCase(charactersRepository)

    @Provides
    fun provideGetListLocationsUseCase(locationsRepository: LocationsRepository) =
        GetListLocationsUseCase(locationsRepository)

    @Provides
    fun provideGetMoreLocationsUseCase(locationsRepository: LocationsRepository) =
        GetMoreLocationsUseCase(locationsRepository)

    @Provides
    fun provideGetListEpisodesUseCase(episodesRepository: EpisodesRepository) =
        GetListEpisodesUseCase(episodesRepository)

    @Provides
    fun provideGetMoreEpisodesUseCase(episodesRepository: EpisodesRepository) =
        GetMoreEpisodesUseCase(episodesRepository)

}