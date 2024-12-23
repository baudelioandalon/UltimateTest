package com.boreal.ultimatetest.games.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GamesModelItemDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "developer") val developer: String?,
    @ColumnInfo(name = "freetogame_profile_url") val freetogame_profile_url: String?,
    @ColumnInfo(name = "game_url") val game_url: String?,
    @ColumnInfo(name = "genre") val genre: String?,
    @ColumnInfo(name = "platform") val platform: String?,
    @ColumnInfo(name = "publisher") val publisher: String?,
    @ColumnInfo(name = "release_date") val release_date: String?,
    @ColumnInfo(name = "short_description") val short_description: String?,
    @ColumnInfo(name = "thumbnail") val thumbnail: String?,
    @ColumnInfo(name = "title") val title: String?
)