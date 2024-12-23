package com.boreal.ultimatetest.games.domain.model

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class GamesResponseModelItem(
    val developer: String = "",
    val freetogame_profile_url: String = "",
    val game_url: String = "",
    val genre: String? = "",
    val id: Int = 1,
    val platform: String = "",
    val publisher: String = "",
    val release_date: String = "",
    val short_description: String = "",
    val thumbnail: String = "",
    val title: String = ""
)


