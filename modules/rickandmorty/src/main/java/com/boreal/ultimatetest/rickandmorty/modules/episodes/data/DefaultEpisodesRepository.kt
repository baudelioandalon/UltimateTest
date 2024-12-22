package com.boreal.ultimatetest.rickandmorty.modules.episodes.data

import com.boreal.ultimatetest.rickandmorty.modules.episodes.data.get_episodes.GetListEpisodesDataSource
import com.boreal.ultimatetest.rickandmorty.modules.episodes.domain.interfaces.EpisodesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultEpisodesRepository @Inject constructor(private val getListEpisodesDataSource: GetListEpisodesDataSource) :
    EpisodesRepository {

    override suspend fun executeGetListEpisodes() = flow {
        emit(getListEpisodesDataSource.executeGetListEpisodes())
    }

    override suspend fun executeGetMoreEpisodes(page: Int) = flow {
        emit(getListEpisodesDataSource.executeGetMoreEpisodes(page))
    }
}