package com.boreal.ultimatetest.modules.locations.data.data_source

import com.boreal.ultimatetest.modules.locations.data.data_source.remote.ExecuteGetListLocationsDataSource
import com.boreal.ultimatetest.modules.locations.data.get_locations.GetListLocationsDataSource
import javax.inject.Inject

class RemoteGetListLocationsDataSource @Inject constructor(private val executeGetListLocationsDataSource: ExecuteGetListLocationsDataSource) :
    GetListLocationsDataSource {

    override suspend fun executeGetListLocations() = executeGetListLocationsDataSource.executeGetListLocations()
    override suspend fun executeGetMoreLocations(page: Int) =
        executeGetListLocationsDataSource.executeGetMoreLocations(page)
}