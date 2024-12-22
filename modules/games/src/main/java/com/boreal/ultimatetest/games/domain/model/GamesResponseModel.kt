package com.boreal.ultimatetest.games.domain.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Serializable
@Immutable
class GamesResponseModel : ArrayList<GamesResponseModelItem>()