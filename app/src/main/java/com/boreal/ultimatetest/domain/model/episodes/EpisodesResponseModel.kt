package com.boreal.ultimatetest.domain.model.episodes

import androidx.compose.runtime.Immutable
import com.boreal.ultimatetest.domain.model.Info

@kotlinx.serialization.Serializable
@Immutable
data class EpisodesResponseModel(
    val info: Info,
    var results: List<EpisodeModel>
)