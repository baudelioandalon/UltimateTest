package com.boreal.ultimatetest.modules.locations.data.get_locations

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel

interface GetListLocationsDataSource {
    suspend fun executeGetListLocations(): ApiResponse<LocationsResponseModel>
    suspend fun executeGetMoreLocations(page: Int): ApiResponse<LocationsResponseModel>
}