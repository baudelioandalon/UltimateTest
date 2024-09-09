package com.boreal.ultimatetest.domain.model

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class RickAndMortyResponseModel(
    val info: Info? = null,
    var results: List<CharacterModel>? = null
)