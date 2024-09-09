package com.boreal.ultimatetest.di

import com.boreal.ultimatetest.modules.home.domain.interfaces.RickAndMortyRepository
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetListUseCase
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetMoreCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetListUseCase(rickAndMortyRepository: RickAndMortyRepository) =
        GetListUseCase(rickAndMortyRepository)

    @Provides
    fun provideGetMoreCharactersListUseCase(rickAndMortyRepository: RickAndMortyRepository) =
        GetMoreCharactersUseCase(rickAndMortyRepository)


}