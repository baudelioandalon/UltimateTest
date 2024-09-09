package com.boreal.ultimatetest.modules.episodes.data.data_source.remote

import com.boreal.ultimatetest.core.BuildConfig
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.domain.model.characters.Endpoints
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import com.boreal.ultimatetest.domain.model.episodes.EpisodesResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class ExecuteGetListEpisodesDataSource @Inject constructor(private val httpClient: HttpClient) {

    /**
     * Get the list of episodes from the API
     * @return ApiResponse<EpisodesResponseModel>
     */
    suspend fun executeGetListEpisodes(): ApiResponse<EpisodesResponseModel> = try {
        val result = httpClient.get("${BuildConfig.BASE_URL}${Endpoints.GET_EPISODES_LIST.url}").body<EpisodesResponseModel>()
        ApiResponse(
            response = result,
            status = StateApi.Success
        )
    } catch (exception: Exception) {
        ApiResponse(
            failure = "Error: ${exception.message}",
            status = StateApi.Error
        )
    }

    /**
     * @param page: Int -> Numero de pagina a obtener
     * Get more locations from the API
     * @return ApiResponse<EpisodesResponseModel>
     */
    suspend fun executeGetMoreEpisodes(page: Int): ApiResponse<EpisodesResponseModel> = try {
        val result = httpClient.get("${BuildConfig.BASE_URL}${Endpoints.GET_MORE_EPISODES.url}$page").body<EpisodesResponseModel>()
        ApiResponse(
            response = result,
            status = StateApi.Success
        )
    } catch (exception: Exception) {
        ApiResponse(
            failure = "Error: ${exception.message}",
            status = StateApi.Error
        )
    }


}