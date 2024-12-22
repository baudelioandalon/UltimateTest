package com.boreal.ultimatetest.games.domain.use_cases

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.UseCase
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.games.domain.interfaces.GamesRepository
import com.boreal.ultimatetest.games.domain.model.GamesResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetListGamesUseCase @Inject constructor(private val charactersRepository: GamesRepository) :
    UseCase<EmptyIn, GetListGamesUseCase.Output> {

    class Output @Inject constructor(val response: ApiResponse<GamesResponseModel>) :
        Out()

    override suspend fun execute(input: EmptyIn): Flow<Output> {
        return charactersRepository.executeGetList().flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }
}