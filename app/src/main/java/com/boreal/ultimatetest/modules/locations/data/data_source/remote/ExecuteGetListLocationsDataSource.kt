package com.boreal.ultimatetest.modules.locations.data.data_source.remote

import com.boreal.ultimatetest.core.BuildConfig
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.domain.model.characters.Endpoints
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class ExecuteGetListLocationsDataSource @Inject constructor(private val httpClient: HttpClient) {

    /**
     * Get the list of locations from the API
     * @return ApiResponse<LocationsResponseModel>
     */
    suspend fun executeGetListLocations(): ApiResponse<LocationsResponseModel> = try {
        val result = httpClient.get("${BuildConfig.BASE_URL}${Endpoints.GET_LOCATIONS_LIST.url}").body<LocationsResponseModel>()
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
     * @return ApiResponse<LocationsResponseModel>
     */
    suspend fun executeGetMoreLocations(page: Int): ApiResponse<LocationsResponseModel> = try {
        val result = httpClient.get("${BuildConfig.BASE_URL}${Endpoints.GET_MORE_LOCATIONS.url}$page").body<LocationsResponseModel>()
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