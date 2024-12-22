package com.boreal.ultimatetest.games.modules.home.data.data_source

import com.boreal.ultimatetest.games.modules.home.data.data_source.remote.ExecuteGetGamesListDataSource
import com.boreal.ultimatetest.games.modules.home.data.get_games.GetListGamesDataSource
import javax.inject.Inject

class RemoteGetListGamesDataSource @Inject constructor(private val executeGetGamesListDataSource: ExecuteGetGamesListDataSource) :
    GetListGamesDataSource {

    override suspend fun executeGetList() = executeGetGamesListDataSource.executeGetList()
}