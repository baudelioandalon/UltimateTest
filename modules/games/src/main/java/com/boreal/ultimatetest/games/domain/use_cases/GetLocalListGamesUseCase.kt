package com.boreal.ultimatetest.games.domain.use_cases

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.Out
import com.boreal.ultimatetest.core.domain.UseCase
import com.boreal.ultimatetest.games.domain.interfaces.GamesLocalRepository
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLocalListGamesUseCase @Inject constructor(private val gamesLocalRepository: GamesLocalRepository) :
    UseCase<EmptyIn, GetLocalListGamesUseCase.Output> {

    class Output @Inject constructor(val response: List<GamesModelItemDto>) :
        Out()

    override suspend fun execute(input: EmptyIn): Flow<Output> {
        return gamesLocalRepository.getAllGames().flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }
}