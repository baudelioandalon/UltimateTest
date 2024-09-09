package com.boreal.ultimatetest.modules.episodes.data

import com.boreal.ultimatetest.modules.episodes.data.get_episodes.GetListEpisodesDataSource
import com.boreal.ultimatetest.modules.episodes.domain.interfaces.EpisodesRepository
import com.boreal.ultimatetest.modules.locations.data.get_locations.GetListLocationsDataSource
import com.boreal.ultimatetest.modules.locations.domain.interfaces.LocationsRepository
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