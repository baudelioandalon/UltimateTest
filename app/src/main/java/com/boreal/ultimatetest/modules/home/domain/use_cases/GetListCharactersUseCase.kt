package com.boreal.ultimatetest.modules.home.domain.use_cases

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.UseCase
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import com.boreal.ultimatetest.modules.home.domain.interfaces.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetListCharactersUseCase @Inject constructor(private val charactersRepository: CharactersRepository):
    UseCase<EmptyIn, GetListCharactersUseCase.Output> {

    class Output @Inject constructor(val response: ApiResponse<RickAndMortyResponseModel>) :
        Out()

    override suspend fun execute(input: EmptyIn): Flow<Output> {
        return charactersRepository.executeGetList().flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }
}