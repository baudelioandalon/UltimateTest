package com.boreal.ultimatetest.modules.home.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun executeGetList(): Flow<ApiResponse<RickAndMortyResponseModel>>
    suspend fun executeGetMoreCharacters(page: Int): Flow<ApiResponse<RickAndMortyResponseModel>>
}