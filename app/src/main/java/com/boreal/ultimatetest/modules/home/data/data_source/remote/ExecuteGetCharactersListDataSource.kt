package com.boreal.ultimatetest.modules.home.data.data_source.remote

import com.boreal.ultimatetest.core.BuildConfig
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.domain.model.characters.Endpoints
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class ExecuteGetCharactersListDataSource @Inject constructor(private val httpClient: HttpClient) {

    /**
     * Get the list of characters from the API
     * @return ApiResponse<RickAndMortyResponseModel>
     */
    suspend fun executeGetList(): ApiResponse<RickAndMortyResponseModel> = try {
        val result = httpClient.get("${BuildConfig.BASE_URL}${Endpoints.GET_CHARACTERS_LIST.url}").body<RickAndMortyResponseModel>()
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
     * Get more characters from the API
     * @return ApiResponse<RickAndMortyResponseModel>
     */
    suspend fun executeGetMore(page: Int): ApiResponse<RickAndMortyResponseModel> = try {
        val result = httpClient.get("${BuildConfig.BASE_URL}${Endpoints.GET_MORE_CHARACTERS.url}$page").body<RickAndMortyResponseModel>()
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