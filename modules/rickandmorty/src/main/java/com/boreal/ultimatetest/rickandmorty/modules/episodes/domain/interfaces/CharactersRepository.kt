package com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.rickandmorty.domain.model.RickAndMortyResponseModel
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun executeGetList(): Flow<ApiResponse<RickAndMortyResponseModel>>
    suspend fun executeGetMoreCharacters(page: Int): Flow<ApiResponse<RickAndMortyResponseModel>>
}