package com.boreal.ultimatetest.rickandmorty.modules.home.data.get_characteres

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.rickandmorty.domain.model.RickAndMortyResponseModel

interface GetListCharactersDataSource {
    suspend fun executeGetList(): ApiResponse<RickAndMortyResponseModel>
    suspend fun executeGetMore(page: Int): ApiResponse<RickAndMortyResponseModel>
}