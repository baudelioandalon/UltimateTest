package com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.model.EpisodesResponseModel
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    suspend fun executeGetListEpisodes(): Flow<ApiResponse<EpisodesResponseModel>>
    suspend fun executeGetMoreEpisodes(page: Int): Flow<ApiResponse<EpisodesResponseModel>>
}