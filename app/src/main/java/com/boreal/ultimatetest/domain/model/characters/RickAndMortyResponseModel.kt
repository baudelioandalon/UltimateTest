package com.boreal.ultimatetest.domain.model.characters

import androidx.compose.runtime.Immutable
import com.boreal.ultimatetest.domain.model.Info
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class RickAndMortyResponseModel(
    val info: Info? = null,
    var results: List<CharacterModel>? = null
)