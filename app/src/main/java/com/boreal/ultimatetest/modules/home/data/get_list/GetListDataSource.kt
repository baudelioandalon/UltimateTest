package com.boreal.ultimatetest.modules.home.data.get_list

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.RickAndMortyResponseModel

interface GetListDataSource {
    suspend fun executeGetList(): ApiResponse<RickAndMortyResponseModel>
    suspend fun executeGetMore(page: Int): ApiResponse<RickAndMortyResponseModel>
}