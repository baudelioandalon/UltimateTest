package com.boreal.ultimatetest.games.domain.use_cases

import com.boreal.ultimatetest.core.domain.In
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.UseCase
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.domain.interfaces.GamesLocalRepository
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import com.boreal.ultimatetest.games.domain.model.GamesResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SetUpdateGameUseCase @Inject constructor(private val gamesLocalRepository: GamesLocalRepository) :
    UseCase<SetUpdateGameUseCase.Input, SetUpdateGameUseCase.Output> {

    class Input @Inject constructor(val game: GamesModelItemDto) : In()

    class Output @Inject constructor(val response: StateApi) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return gamesLocalRepository.updateGame(input.game).map {
            Output(it)
        }
    }
}