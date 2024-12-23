package com.boreal.ultimatetest.games.di


import com.boreal.ultimatetest.games.domain.interfaces.GamesLocalRepository
import com.boreal.ultimatetest.games.domain.interfaces.GamesRepository
import com.boreal.ultimatetest.games.modules.edit_data.data.DefaultGamesLocalRepository
import com.boreal.ultimatetest.games.modules.home.data.DefaultGamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryGamesModule {

    @Binds
    abstract fun bindGamesRepository(
        defaultGamesRepository: DefaultGamesRepository
    ): GamesRepository


    @Binds
    abstract fun bindGamesLocalRepository(
        defaultGamesLocalRepository: DefaultGamesLocalRepository
    ): GamesLocalRepository

}