package com.boreal.ultimatetest.di

import com.boreal.ultimatetest.modules.home.data.data_source.RemoteGetListDataSource
import com.boreal.ultimatetest.modules.home.data.get_list.GetListDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    fun provideRemoteGetListDataSource(remoteGetListDataSource: RemoteGetListDataSource): GetListDataSource = remoteGetListDataSource


}