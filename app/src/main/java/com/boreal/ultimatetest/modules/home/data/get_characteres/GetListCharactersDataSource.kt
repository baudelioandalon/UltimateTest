package com.boreal.ultimatetest.modules.home.data.get_characteres

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel

interface GetListCharactersDataSource {
    suspend fun executeGetList(): ApiResponse<RickAndMortyResponseModel>
    suspend fun executeGetMore(page: Int): ApiResponse<RickAndMortyResponseModel>
}