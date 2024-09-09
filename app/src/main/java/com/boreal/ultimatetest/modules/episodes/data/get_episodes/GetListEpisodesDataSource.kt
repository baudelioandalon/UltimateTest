package com.boreal.ultimatetest.modules.episodes.data.get_episodes

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import com.boreal.ultimatetest.domain.model.episodes.EpisodesResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel

interface GetListEpisodesDataSource {
    suspend fun executeGetListEpisodes(): ApiResponse<EpisodesResponseModel>
    suspend fun executeGetMoreEpisodes(page: Int): ApiResponse<EpisodesResponseModel>
}