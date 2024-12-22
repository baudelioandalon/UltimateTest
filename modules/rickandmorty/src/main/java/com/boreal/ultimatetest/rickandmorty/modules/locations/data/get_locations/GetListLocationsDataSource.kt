package com.boreal.ultimatetest.rickandmorty.modules.locations.data.get_locations

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.model.LocationsResponseModel

interface GetListLocationsDataSource {
    suspend fun executeGetListLocations(): ApiResponse<LocationsResponseModel>
    suspend fun executeGetMoreLocations(page: Int): ApiResponse<LocationsResponseModel>
}