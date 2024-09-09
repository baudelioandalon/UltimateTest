package com.boreal.ultimatetest.domain.model

import androidx.compose.runtime.Immutable


@kotlinx.serialization.Serializable
@Immutable
data class CharacterModel(
    val created: String="",
    val episode: List<String> = emptyList(),
    val gender: String="",
    val id: Int = 0,
    val image: String = "",
    val location: Location = Location(),
    val name: String    = "",
    val origin: Origin = Origin(),
    val species: String = "",
    val status: String = "",
    val type: String = "",
    val url: String = ""
)