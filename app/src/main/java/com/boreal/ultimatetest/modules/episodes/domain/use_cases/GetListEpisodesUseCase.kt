package com.boreal.ultimatetest.modules.episodes.domain.use_cases

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.UseCase
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.episodes.EpisodesResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel
import com.boreal.ultimatetest.modules.episodes.domain.interfaces.EpisodesRepository
import com.boreal.ultimatetest.modules.locations.domain.interfaces.LocationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetListEpisodesUseCase @Inject constructor(private val episodesRepository: EpisodesRepository):
    UseCase<EmptyIn, GetListEpisodesUseCase.Output> {

    class Output @Inject constructor(val response: ApiResponse<EpisodesResponseModel>) :
        Out()

    override suspend fun execute(input: EmptyIn): Flow<Output> {
        return episodesRepository.executeGetListEpisodes().flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }
}