package com.boreal.ultimatetest.modules.home.data.data_source

import com.boreal.ultimatetest.modules.home.data.data_source.remote.ExecuteGetCharactersListDataSource
import com.boreal.ultimatetest.modules.home.data.get_characteres.GetListCharactersDataSource
import javax.inject.Inject

class RemoteGetListCharactersDataSource @Inject constructor(private val executeGetCharactersListDataSource: ExecuteGetCharactersListDataSource) :
    GetListCharactersDataSource {

    override suspend fun executeGetList() = executeGetCharactersListDataSource.executeGetList()
    override suspend fun executeGetMore(page: Int) =
        executeGetCharactersListDataSource.executeGetMore(page)
}