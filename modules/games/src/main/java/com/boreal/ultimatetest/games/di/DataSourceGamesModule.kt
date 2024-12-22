package com.boreal.ultimatetest.games.di

import com.boreal.ultimatetest.games.modules.home.data.data_source.RemoteGetListGamesDataSource
import com.boreal.ultimatetest.games.modules.home.data.get_games.GetListGamesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataSourceGamesModule {

    @Provides
    fun provideRemoteGetListGamesDataSource(remoteGetListGamesDataSource: RemoteGetListGamesDataSource): GetListGamesDataSource =
        remoteGetListGamesDataSource


}