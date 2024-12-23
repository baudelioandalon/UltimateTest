package com.boreal.ultimatetest.games.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import kotlinx.coroutines.flow.Flow

interface GamesLocalRepository {

    suspend fun getAllGames(): Flow<List<GamesModelItemDto>>

    suspend fun insertGame(game: GamesModelItemDto):Flow<StateApi>

    suspend fun updateGame(game: GamesModelItemDto):Flow<StateApi>

    suspend fun deleteGame(gameId: Int):Flow<StateApi>
}