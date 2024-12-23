package com.boreal.ultimatetest.games.domain.use_cases

import com.boreal.ultimatetest.core.domain.In
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.UseCase
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.domain.interfaces.GamesLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DeleteGameUseCase @Inject constructor(private val gamesLocalRepository: GamesLocalRepository) :
    UseCase<DeleteGameUseCase.Input, DeleteGameUseCase.Output> {

    class Input @Inject constructor(val gameId: Int) : In()

    class Output @Inject constructor(val response: StateApi) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return gamesLocalRepository.deleteGame(input.gameId).map {
            Output(it)
        }
    }
}