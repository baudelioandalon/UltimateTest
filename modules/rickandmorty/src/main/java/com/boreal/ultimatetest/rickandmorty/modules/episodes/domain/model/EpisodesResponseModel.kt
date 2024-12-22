package com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.model

import androidx.compose.runtime.Immutable
import com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.model.EpisodeModel
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model.Info

@kotlinx.serialization.Serializable
@Immutable
data class EpisodesResponseModel(
    val info: Info,
    var results: List<EpisodeModel>
)