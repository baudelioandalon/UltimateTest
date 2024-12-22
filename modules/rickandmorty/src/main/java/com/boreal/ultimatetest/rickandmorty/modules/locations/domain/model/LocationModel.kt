package com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class LocationModel(
    val created: String = "",
    val dimension: String = "",
    val id: Int = 0,
    val name: String = "",
    val residents: List<String>? = null,
    val type: String = "",
    val url: String = ""
)