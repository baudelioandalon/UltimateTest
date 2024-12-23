package com.boreal.ultimatetest.games.domain.interfaces

import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import javax.inject.Inject

class GamesLocalRepository @Inject constructor(
    private val gamesDao: GamesDao
) {

    fun getAllGames(): List<GamesModelItemDto> {
        return gamesDao.getAllGames()
    }

    fun insertGame(user: GamesModelItemDto) {
        gamesDao.insertAll(user)
    }

    fun updateGame(user: GamesModelItemDto) {
        gamesDao.updateGame(
            id = user.id,
            title = user.title.orEmpty(),
            genre = user.genre.orEmpty(),
            publisher = user.publisher.orEmpty(),
            releaseDate = user.release_date.orEmpty(),
            description = user.short_description.orEmpty(),
        )
    }

    fun deleteGame(user: GamesModelItemDto) {
        gamesDao.deleteGame(user)
    }
}