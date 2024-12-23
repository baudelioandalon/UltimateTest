package com.boreal.ultimatetest.games.di

import com.boreal.ultimatetest.games.domain.interfaces.GamesLocalRepository
import com.boreal.ultimatetest.games.modules.home.data.data_source.remote.ExecuteGetGamesListDataSource
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@dagger.Module
@InstallIn(SingletonComponent::class)
object GamesApiModule {


    @Provides
    fun provideExecuteGetListDataSource(httpClient: HttpClient, gamesLocalRepository: GamesLocalRepository): ExecuteGetGamesListDataSource =
        ExecuteGetGamesListDataSource(
            httpClient,
            gamesLocalRepository
        )

}