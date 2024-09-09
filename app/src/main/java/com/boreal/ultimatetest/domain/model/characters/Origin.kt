package com.boreal.ultimatetest.domain.model.characters

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class Origin(
    val name: String = "",
    val url: String = ""
)