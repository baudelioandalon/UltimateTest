package com.boreal.ultimatetest.rickandmorty.modules.episodes.data.get_episodes

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.model.EpisodesResponseModel

interface GetListEpisodesDataSource {
    suspend fun executeGetListEpisodes(): ApiResponse<EpisodesResponseModel>
    suspend fun executeGetMoreEpisodes(page: Int): ApiResponse<EpisodesResponseModel>
}