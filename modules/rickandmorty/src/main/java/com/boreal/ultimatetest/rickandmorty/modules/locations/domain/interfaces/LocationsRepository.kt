package com.boreal.ultimatetest.rickandmorty.modules.locations.domain.interfaces

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model.LocationsResponseModel
import kotlinx.coroutines.flow.Flow

interface LocationsRepository {
    suspend fun executeGetListLocations(): Flow<ApiResponse<LocationsResponseModel>>
    suspend fun executeGetMoreLocations(page: Int): Flow<ApiResponse<LocationsResponseModel>>
}