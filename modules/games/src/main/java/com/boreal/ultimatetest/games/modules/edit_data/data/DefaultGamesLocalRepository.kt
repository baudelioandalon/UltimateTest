package com.boreal.ultimatetest.games.modules.edit_data.data

import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.domain.interfaces.GamesDao
import com.boreal.ultimatetest.games.domain.interfaces.GamesLocalRepository
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultGamesLocalRepository @Inject constructor(
    private val dao: GamesDao
) : GamesLocalRepository {

    override suspend fun getAllGames(): Flow<List<GamesModelItemDto>> {
        return withContext(Dispatchers.IO) {
            dao.getAllGames()
        }
    }

    override suspend fun insertGame(game: GamesModelItemDto): Flow<StateApi> {
        withContext(Dispatchers.IO) {
            dao.insertAll(game)
        }
        return flowOf(StateApi.Success)
    }

    override suspend fun updateGame(game: GamesModelItemDto): Flow<StateApi> {
        withContext(Dispatchers.IO) {
            dao.updateGame(
                id = game.id,
                title = game.title.orEmpty(),
                description = game.short_description.orEmpty(),
                genre = game.genre.orEmpty(),
                publisher = game.publisher.orEmpty(),
                releaseDate = game.release_date.orEmpty(),
            )
        }
        return flowOf(StateApi.Success)
    }

    override suspend fun deleteGame(gameId: Int): Flow<StateApi> {
        withContext(Dispatchers.IO) {
            dao.deleteGame(gameId)
        }
        return flowOf(StateApi.Success)
    }

}