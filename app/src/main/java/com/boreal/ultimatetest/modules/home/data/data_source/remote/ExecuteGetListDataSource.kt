package com.boreal.ultimatetest.modules.home.data.data_source.remote

import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.domain.model.CharacterModel
import com.boreal.ultimatetest.domain.model.Info
import com.boreal.ultimatetest.domain.model.Location
import com.boreal.ultimatetest.domain.model.Origin
import com.boreal.ultimatetest.domain.model.RickAndMortyResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class ExecuteGetListDataSource @Inject constructor(private val httpClient: HttpClient) {

    suspend fun executeGetList(): ApiResponse<RickAndMortyResponseModel> = try {

        val result = httpClient.get("https://rickandmortyapi.com/api/character").body<RickAndMortyResponseModel>()

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