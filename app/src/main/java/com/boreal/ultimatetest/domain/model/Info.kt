package com.boreal.ultimatetest.domain.model

@kotlinx.serialization.Serializable
data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)