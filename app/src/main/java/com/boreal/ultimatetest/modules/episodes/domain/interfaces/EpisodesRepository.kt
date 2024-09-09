package com.boreal.ultimatetest.modules.episodes.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import com.boreal.ultimatetest.domain.model.episodes.EpisodesResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    suspend fun executeGetListEpisodes(): Flow<ApiResponse<EpisodesResponseModel>>
    suspend fun executeGetMoreEpisodes(page: Int): Flow<ApiResponse<EpisodesResponseModel>>
}