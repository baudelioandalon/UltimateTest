package com.boreal.ultimatetest.modules.episodes.data.data_source

import com.boreal.ultimatetest.modules.episodes.data.data_source.remote.ExecuteGetListEpisodesDataSource
import com.boreal.ultimatetest.modules.episodes.data.get_episodes.GetListEpisodesDataSource
import com.boreal.ultimatetest.modules.locations.data.data_source.remote.ExecuteGetListLocationsDataSource
import com.boreal.ultimatetest.modules.locations.data.get_locations.GetListLocationsDataSource
import javax.inject.Inject

class RemoteGetListEpisodesDataSource @Inject constructor(private val executeGetListEpisodesDataSource: ExecuteGetListEpisodesDataSource) :
    GetListEpisodesDataSource {

    override suspend fun executeGetListEpisodes() = executeGetListEpisodesDataSource.executeGetListEpisodes()
    override suspend fun executeGetMoreEpisodes(page: Int) =
        executeGetListEpisodesDataSource.executeGetMoreEpisodes(page)
}