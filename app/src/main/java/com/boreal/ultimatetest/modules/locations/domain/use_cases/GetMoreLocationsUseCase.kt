package com.boreal.ultimatetest.modules.locations.domain.use_cases

import com.boreal.ultimatetest.core.domain.In
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.UseCase
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel
import com.boreal.ultimatetest.modules.locations.domain.interfaces.LocationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMoreLocationsUseCase @Inject constructor(private val locationsRepository: LocationsRepository) :
    UseCase<GetMoreLocationsUseCase.Input, GetMoreLocationsUseCase.Output> {

    class Input @Inject constructor(val request: Int) : In()

    class Output @Inject constructor(val response: ApiResponse<LocationsResponseModel>) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return locationsRepository.executeGetMoreLocations(input.request).flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }
}