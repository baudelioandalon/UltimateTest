package com.boreal.ultimatetest.di

import android.util.Log
import com.boreal.ultimatetest.core.BuildConfig
import com.boreal.ultimatetest.modules.home.data.data_source.remote.ExecuteGetCharactersListDataSource
import com.boreal.ultimatetest.modules.locations.data.data_source.remote.ExecuteGetListLocationsDataSource
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("Logger Ktor =>", message)
                    }

                }
                level = LogLevel.ALL
            }
            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("HTTP status:", "${response.status.value}")
                }
            }
            install(DefaultRequest) {
                url(BuildConfig.BASE_URL)
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }

    @Provides
    fun provideExecuteGetListDataSource(httpClient: HttpClient): ExecuteGetCharactersListDataSource =
        ExecuteGetCharactersListDataSource(httpClient)

    @Provides
    fun provideExecuteGetListLocationsDataSource(httpClient: HttpClient): ExecuteGetListLocationsDataSource =
        ExecuteGetListLocationsDataSource(httpClient)
}