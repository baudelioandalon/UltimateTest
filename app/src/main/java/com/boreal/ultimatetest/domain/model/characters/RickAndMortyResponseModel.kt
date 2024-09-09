package com.boreal.ultimatetest.domain.model.characters

import androidx.compose.runtime.Immutable
import com.boreal.ultimatetest.domain.model.Info

@kotlinx.serialization.Serializable
@Immutable
data class RickAndMortyResponseModel(
    val info: Info? = null,
    var results: List<CharacterModel>? = null
)