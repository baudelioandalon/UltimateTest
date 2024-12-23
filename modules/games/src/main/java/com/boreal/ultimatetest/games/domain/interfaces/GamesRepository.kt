package com.boreal.ultimatetest.games.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
    suspend fun executeGetList(): Flow<ApiResponse<StateApi>>
}