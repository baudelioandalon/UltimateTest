package com.boreal.ultimatetest.games.modules.home.data

import com.boreal.ultimatetest.games.domain.interfaces.GamesRepository
import com.boreal.ultimatetest.games.modules.home.data.get_games.GetListGamesDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultGamesRepository @Inject constructor(private val getListGamesDataSource: GetListGamesDataSource) :
    GamesRepository {

    override suspend fun executeGetList() = flow {
        emit(getListGamesDataSource.executeGetList())
    }
}