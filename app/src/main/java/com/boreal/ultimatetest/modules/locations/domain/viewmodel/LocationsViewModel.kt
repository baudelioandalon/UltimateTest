package com.boreal.ultimatetest.modules.locations.domain.viewmodel

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.base.BaseViewModel
import com.boreal.ultimatetest.core.domain.base.UiState
import com.boreal.ultimatetest.core.domain.base.log
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.core.domain.network.error
import com.boreal.ultimatetest.core.domain.network.loading
import com.boreal.ultimatetest.core.domain.network.success
import com.boreal.ultimatetest.domain.model.characters.RickAndMortyResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetListCharactersUseCase
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetMoreCharactersUseCase
import com.boreal.ultimatetest.modules.locations.domain.use_cases.GetListLocationsUseCase
import com.boreal.ultimatetest.modules.locations.domain.use_cases.GetMoreLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val getListLocationsUseCase: GetListLocationsUseCase,
    private val getMoreLocationsUseCase: GetMoreLocationsUseCase
) : BaseViewModel() {


    private val _locationsList = MutableStateFlow<ApiResponse<LocationsResponseModel>?>(null)
    private val _uiStateLocationsList = MutableStateFlow<UiState<LocationsResponseModel?>>(UiState.None)
    val uiStateLocationsList: StateFlow<UiState<LocationsResponseModel?>> = _uiStateLocationsList


    /**
     * @see Obtener la lista de personajes
     * @param Sin parametros de entrada
     * @return ApiResponse<RickAndMortyResponseModel>
     */
    fun getLocationsList() {
        executeFlow {
            if (_locationsList.value?.status == StateApi.Loading || _locationsList.value?.status == StateApi.Success) return@executeFlow
            _locationsList.update {
                loading()
            }
            _uiStateLocationsList.value = UiState.Loading
            getListLocationsUseCase.execute(
                EmptyIn
            ).catch { cause ->
                _locationsList.update {
                    error(cause.message ?: "Error")
                }
                _uiStateLocationsList.value = UiState.Error(cause.message ?: "Error")
            }.collect { result ->
                result.response.success { response ->
                    _locationsList.update {
                        response
                    }
                    _uiStateLocationsList.value = UiState.Success(response.response)
                }
                result.response.error { error ->
                    _locationsList.update {
                        error
                    }
                    _uiStateLocationsList.value = UiState.Error(error.failure ?: "Error")
                }
            }
        }
    }

    /**
     * @see Obtener más personajes de las paginas siguientes
     */
    fun getMoreLocations() {

        if (_locationsList.value?.status == StateApi.Success && _locationsList.value?.response?.info?.next.isNullOrEmpty()) {
            "No hay más personajes".log("MAX_RESULTS")
            return
        }
        executeFlow {
            delay(500)
            if (_locationsList.value?.status == StateApi.Loading ) return@executeFlow
            _locationsList.update {
                loading(
                    savedBundle = _locationsList.value?.response
                )
            }
            _uiStateLocationsList.value = UiState.Loading
            getMoreLocationsUseCase.execute(
                GetMoreLocationsUseCase.Input(
                    request = _locationsList.value?.response?.info?.next?.split("=")?.last()?.toIntOrNull() ?: 1
                )
            ).catch { cause ->
                _locationsList.update {
                    error(cause.message ?: "Error")
                }
                _uiStateLocationsList.value = UiState.Error(cause.message ?: "Error")
            }.collect { result ->

                result.response.success { response ->
                    _locationsList.update {
                        with(response) {
                            response.response?.results = (_locationsList.value?.response?.results
                                ?: emptyList()) + (response.response?.results ?: emptyList())
                            response
                        }
                    }
                    _uiStateLocationsList.value = UiState.Success(response.response)
                }
                result.response.error { error ->
                    _locationsList.update {
                        with(_locationsList.value){
                            this?.status = StateApi.Success
                            this
                        }
                    }
                    "Algo salio mal ${error.failure}".log("ERROR")
                    _uiStateLocationsList.value = UiState.Success(_locationsList.value?.response)
                }
            }
        }
    }


}