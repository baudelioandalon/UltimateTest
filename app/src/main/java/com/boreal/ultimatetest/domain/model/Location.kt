package com.boreal.ultimatetest.domain.model

@kotlinx.serialization.Serializable
data class Location(
    val name: String = "",
    val url: String = ""
)