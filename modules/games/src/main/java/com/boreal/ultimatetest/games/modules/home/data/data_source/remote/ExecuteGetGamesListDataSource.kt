package com.boreal.ultimatetest.games.modules.home.data.data_source.remote

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.BuildConfig
import com.boreal.ultimatetest.games.domain.interfaces.AppDatabase
import com.boreal.ultimatetest.games.domain.interfaces.GamesLocalRepository
import com.boreal.ultimatetest.games.domain.model.EndpointsGames
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import com.boreal.ultimatetest.games.domain.model.GamesResponseModel
import com.boreal.ultimatetest.games.domain.model.GamesResponseModelItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json
import javax.inject.Inject

class ExecuteGetGamesListDataSource @Inject constructor(
    private val httpClient: HttpClient,
    private val gamesLocalRepository: GamesLocalRepository
) {

    /**
     * Get the list of games from the API
     * @return ApiResponse<GamesResponseModel>
     */
    suspend fun executeGetList(): ApiResponse<StateApi> = try {

        val result = httpClient.get("${BuildConfig.BASE_URL}${EndpointsGames.GET_GAMES_LIST.url}")
        val actual = Json.decodeFromString<List<GamesResponseModelItem>>(result.body())

        if (result.status.value == HttpStatusCode.OK.value) {
            actual.forEach { item ->
                gamesLocalRepository.insertGame(
                    GamesModelItemDto(
                        id = item.id,
                        title = item.title,
                        thumbnail = item.thumbnail,
                        short_description = item.short_description,
                        game_url = item.game_url,
                        genre = item.genre,
                        release_date = item.release_date,
                        developer = item.developer,
                        freetogame_profile_url = item.freetogame_profile_url,
                        platform = item.platform,
                        publisher = item.publisher
                    )
                )
            }
        }

        ApiResponse(
            response = StateApi.Success,
            status = StateApi.Success
        )
    } catch (exception: Exception) {
        ApiResponse(
            failure = "Error: ${exception.message}",
            status = StateApi.Error
        )
    }


}
