package com.boreal.ultimatetest.domain.model

@kotlinx.serialization.Serializable
data class RickAndMortyResponseModel(
    val info: Info? = null,
    val results: List<CharacterModel>? = null
)