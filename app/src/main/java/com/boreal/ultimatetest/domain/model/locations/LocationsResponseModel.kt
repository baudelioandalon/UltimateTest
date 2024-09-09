package com.boreal.ultimatetest.domain.model.locations

import androidx.compose.runtime.Immutable

@kotlinx.serialization.Serializable
@Immutable
data class LocationsResponseModel(
    val info: Info? = null,
    var results: List<LocationModel>? = null
)