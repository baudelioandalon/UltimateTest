package com.boreal.ultimatetest.domain.model.locations

import androidx.compose.runtime.Immutable
import com.boreal.ultimatetest.domain.model.Info

@kotlinx.serialization.Serializable
@Immutable
data class LocationsResponseModel(
    val info: Info? = null,
    var results: List<LocationModel>? = null
)