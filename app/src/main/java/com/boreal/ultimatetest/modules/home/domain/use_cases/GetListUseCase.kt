package com.boreal.ultimatetest.modules.home.domain.use_cases

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.RickAndMortyResponseModel
import com.boreal.ultimatetest.modules.home.domain.interfaces.RickAndMortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetListUseCase @Inject constructor(private val rickAndMortyRepository: RickAndMortyRepository) {

    class Output @Inject constructor(val response: ApiResponse<RickAndMortyResponseModel>) :
        Out()

    suspend fun execute(input: EmptyIn): Flow<Output> {
        return rickAndMortyRepository.executeGetList().flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }
}