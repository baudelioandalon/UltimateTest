package com.boreal.ultimatetest.rickandmorty.domain.model

import androidx.compose.runtime.Immutable
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model.Info
import kotlinx.serialization.Serializable

@Serializable
@Immutable
data class RickAndMortyResponseModel(
    val info: Info? = null,
    var results: List<CharacterModel>? = null
)