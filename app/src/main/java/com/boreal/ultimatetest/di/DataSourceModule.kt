package com.boreal.ultimatetest.di

import com.boreal.ultimatetest.modules.home.data.data_source.RemoteGetListCharactersDataSource
import com.boreal.ultimatetest.modules.home.data.get_characteres.GetListCharactersDataSource
import com.boreal.ultimatetest.modules.locations.data.data_source.RemoteGetListLocationsDataSource
import com.boreal.ultimatetest.modules.locations.data.get_locations.GetListLocationsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    fun provideRemoteGetListCharactersDataSource(remoteGetListCharactersDataSource: RemoteGetListCharactersDataSource): GetListCharactersDataSource =
        remoteGetListCharactersDataSource

    @Provides
    fun provideRemoteGetListLocationsDataSource(remoteGetListLocationsDataSource: RemoteGetListLocationsDataSource): GetListLocationsDataSource =
        remoteGetListLocationsDataSource

}