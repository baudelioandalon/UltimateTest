package com.boreal.ultimatetest.domain.model

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)