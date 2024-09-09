package com.boreal.ultimatetest.domain.model

@kotlinx.serialization.Serializable
data class Origin(
    val name: String = "",
    val url: String = ""
)