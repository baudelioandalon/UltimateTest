package com.boreal.ultimatetest.rickandmorty.modules.locations.data

import com.boreal.ultimatetest.rickandmorty.modules.locations.data.get_locations.GetListLocationsDataSource
import com.boreal.ultimatetest.rickandmorty.modules.locations.domain.interfaces.LocationsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultLocationsRepository @Inject constructor(private val getListLocationsDataSource: GetListLocationsDataSource) :
    LocationsRepository {

    override suspend fun executeGetListLocations() = flow {
        emit(getListLocationsDataSource.executeGetListLocations())
    }

    override suspend fun executeGetMoreLocations(page: Int) = flow {
        emit(getListLocationsDataSource.executeGetMoreLocations(page))
    }
}