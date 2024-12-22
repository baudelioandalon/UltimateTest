package com.boreal.ultimatetest.games.modules.home.data.data_source.remote

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.BuildConfig
import com.boreal.ultimatetest.games.domain.model.EndpointsGames
import com.boreal.ultimatetest.games.domain.model.GamesResponseModel
import com.boreal.ultimatetest.games.domain.model.GamesResponseModelItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ExecuteGetGamesListDataSource @Inject constructor(private val httpClient: HttpClient) {

    /**
     * Get the list of games from the API
     * @return ApiResponse<GamesResponseModel>
     */
    suspend fun executeGetList(): ApiResponse<GamesResponseModel> = try {

        val result = httpClient.get("${BuildConfig.BASE_URL}${EndpointsGames.GET_GAMES_LIST.url}")
        val actual = Json.decodeFromString<List<GamesResponseModelItem>>(result.body())

        ApiResponse(
            response = with(GamesResponseModel()) {
                addAll(actual)
                this
            },
            status = StateApi.Success
        )
    } catch (exception: Exception) {
        ApiResponse(
            failure = "Error: ${exception.message}",
            status = StateApi.Error
        )
    }


}
