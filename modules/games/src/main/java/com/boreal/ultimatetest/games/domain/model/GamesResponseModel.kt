package com.boreal.ultimatetest.games.domain.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
@Immutable
class GamesResponseModel : ArrayList<GamesResponseModelItem>() {
    fun convertToList(list: List<GamesModelItemDto>): GamesResponseModel {
        list.forEach { model ->
            add(
                GamesResponseModelItem(
                    developer = model.developer.orEmpty(),
                    freetogame_profile_url = model.freetogame_profile_url.orEmpty(),
                    game_url = model.game_url.orEmpty(),
                    genre = model.genre.orEmpty(),
                    id = model.id,
                    platform = model.platform.orEmpty(),
                    publisher = model.publisher.orEmpty(),
                    release_date = model.release_date.orEmpty(),
                    short_description = model.short_description.orEmpty(),
                    thumbnail = model.thumbnail.orEmpty(),
                    title = model.title.orEmpty()
                )
            )
        }
        return this
    }
}