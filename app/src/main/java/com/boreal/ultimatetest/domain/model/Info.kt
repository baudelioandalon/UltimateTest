package com.boreal.ultimatetest.domain.model

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class Info(
    val count: Int? = null,
    val next: String? = null,
    val pages: Int? = null,
    val prev: String? = null
)