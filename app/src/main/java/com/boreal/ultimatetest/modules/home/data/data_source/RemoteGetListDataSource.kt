package com.boreal.ultimatetest.modules.home.data.data_source

import com.boreal.ultimatetest.modules.home.data.data_source.remote.ExecuteGetListDataSource
import com.boreal.ultimatetest.modules.home.data.get_list.GetListDataSource
import javax.inject.Inject

class RemoteGetListDataSource @Inject constructor(private val executeGetListDataSource: ExecuteGetListDataSource) :
    GetListDataSource {


    override suspend fun executeGetList() = executeGetListDataSource.executeGetList()
}