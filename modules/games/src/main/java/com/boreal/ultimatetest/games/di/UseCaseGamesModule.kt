package com.boreal.ultimatetest.games.di

import com.boreal.ultimatetest.games.domain.interfaces.GamesRepository
import com.boreal.ultimatetest.games.domain.use_cases.GetListGamesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCaseGamesModule {

    @Provides
    fun provideGetListGamesUseCase(charactersRepository: GamesRepository) =
        GetListGamesUseCase(charactersRepository)


}