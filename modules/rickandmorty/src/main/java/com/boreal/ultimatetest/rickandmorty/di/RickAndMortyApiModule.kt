package com.boreal.ultimatetest.rickandmorty.di

import com.boreal.ultimatetest.rickandmorty.modules.episodes.data.data_source.remote.ExecuteGetListEpisodesDataSource
import com.boreal.ultimatetest.rickandmorty.modules.home.data.data_source.remote.ExecuteGetCharactersListDataSource
import com.boreal.ultimatetest.rickandmorty.modules.locations.data.data_source.remote.ExecuteGetListLocationsDataSource
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@dagger.Module
@InstallIn(SingletonComponent::class)
object RickAndMortyApiModule {


    @Provides
    fun provideExecuteGetListDataSource(httpClient: HttpClient): ExecuteGetCharactersListDataSource =
        ExecuteGetCharactersListDataSource(
            httpClient
        )

    @Provides
    fun provideExecuteGetListLocationsDataSource(httpClient: HttpClient): ExecuteGetListLocationsDataSource =
        ExecuteGetListLocationsDataSource(
            httpClient
        )

    @Provides
    fun provideExecuteGetListEpisodesDataSource(httpClient: HttpClient): ExecuteGetListEpisodesDataSource =
        ExecuteGetListEpisodesDataSource(
            httpClient
        )
}