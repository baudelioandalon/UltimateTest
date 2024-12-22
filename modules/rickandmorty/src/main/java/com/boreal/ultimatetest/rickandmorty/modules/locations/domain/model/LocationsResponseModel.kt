package com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model

import androidx.compose.runtime.Immutable
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model.Info
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model.LocationModel

@kotlinx.serialization.Serializable
@Immutable
data class LocationsResponseModel(
    val info: Info? = null,
    var results: List<LocationModel>? = null
)