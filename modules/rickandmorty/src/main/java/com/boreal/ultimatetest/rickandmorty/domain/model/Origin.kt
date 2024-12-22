package com.boreal.ultimatetest.rickandmorty.domain.model

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class Origin(
    val name: String = "",
    val url: String = ""
)