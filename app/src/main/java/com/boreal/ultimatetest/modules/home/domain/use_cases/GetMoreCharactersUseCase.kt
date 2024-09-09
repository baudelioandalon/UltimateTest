package com.boreal.ultimatetest.modules.home.domain.use_cases

import com.boreal.ultimatetest.core.domain.In
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

class GetMoreCharactersUseCase @Inject constructor(private val charactersRepository: CharactersRepository) :
    UseCase<GetMoreCharactersUseCase.Input, GetMoreCharactersUseCase.Output> {

    class Input @Inject constructor(val request: Int) : In()

    class Output @Inject constructor(val response: ApiResponse<RickAndMortyResponseModel>) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return charactersRepository.executeGetMoreCharacters(input.request).flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }
}