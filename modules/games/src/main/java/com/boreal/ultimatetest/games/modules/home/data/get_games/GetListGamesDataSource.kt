package com.boreal.ultimatetest.games.modules.home.data.get_games

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.games.domain.model.GamesResponseModel

interface GetListGamesDataSource {
    suspend fun executeGetList(): ApiResponse<GamesResponseModel>
}