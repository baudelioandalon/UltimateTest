package com.boreal.ultimatetest.domain.model

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class Location(
    val name: String = "",
    val url: String = ""
)