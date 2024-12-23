package com.boreal.ultimatetest.games.domain.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto

@Dao
interface GamesDao {
    @Query("SELECT * FROM games")
    fun getAllGames(): List<GamesModelItemDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: GamesModelItemDto)

    @Query("UPDATE games SET title=:title, short_description=:description, genre=:genre, publisher=:publisher, release_date=:releaseDate WHERE id = :id")
    fun updateGame(
        id: Int,
        title: String,
        description: String,
        genre: String,
        publisher: String,
        releaseDate: String
    )

    @Delete
    fun deleteGame(user: GamesModelItemDto)
}