package com.boreal.ultimatetest.modules.home.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.RickAndMortyResponseModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun executeGetList(): Flow<ApiResponse<RickAndMortyResponseModel>>
    suspend fun executeGetMoreCharacters(page: Int): Flow<ApiResponse<RickAndMortyResponseModel>>
}