package com.boreal.ultimatetest.modules.episodes.domain.viewmodel

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
import com.boreal.ultimatetest.domain.model.episodes.EpisodesResponseModel
import com.boreal.ultimatetest.domain.model.locations.LocationsResponseModel
import com.boreal.ultimatetest.modules.episodes.domain.use_cases.GetListEpisodesUseCase
import com.boreal.ultimatetest.modules.episodes.domain.use_cases.GetMoreEpisodesUseCase
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
class EpisodesViewModel @Inject constructor(
    private val getListEpisodesUseCase: GetListEpisodesUseCase,
    private val getMoreEpisodesUseCase: GetMoreEpisodesUseCase
) : BaseViewModel() {


    private val _episodesList = MutableStateFlow<ApiResponse<EpisodesResponseModel>?>(null)
    private val _uiStateEpisodesList = MutableStateFlow<UiState<EpisodesResponseModel?>>(UiState.None)
    val uiStateEpisodesList: StateFlow<UiState<EpisodesResponseModel?>> = _uiStateEpisodesList


    /**
     * @see Obtener la lista de episodios
     * @param Sin parametros de entrada
     * @return ApiResponse<EpisodesResponseModel>
     */
    fun getEpisodesList() {
        executeFlow {
            if (_episodesList.value?.status == StateApi.Loading || _episodesList.value?.status == StateApi.Success) return@executeFlow
            _episodesList.update {
                loading()
            }
            _uiStateEpisodesList.value = UiState.Loading
            getListEpisodesUseCase.execute(
                EmptyIn
            ).catch { cause ->
                _episodesList.update {
                    error(cause.message ?: "Error")
                }
                _uiStateEpisodesList.value = UiState.Error(cause.message ?: "Error")
            }.collect { result ->
                result.response.success { response ->
                    _episodesList.update {
                        response
                    }
                    _uiStateEpisodesList.value = UiState.Success(response.response)
                }
                result.response.error { error ->
                    _episodesList.update {
                        error
                    }
                    _uiStateEpisodesList.value = UiState.Error(error.failure ?: "Error")
                }
            }
        }
    }

    /**
     * @see Obtener más episodios de las paginas siguientes
     */
    fun getMoreEpisodes() {

        if (_episodesList.value?.status == StateApi.Success && _episodesList.value?.response?.info?.next.isNullOrEmpty()) {
            "No hay más episodios".log("MAX_RESULTS")
            return
        }
        executeFlow {
            delay(500)
            if (_episodesList.value?.status == StateApi.Loading ) return@executeFlow
            _episodesList.update {
                loading(
                    savedBundle = _episodesList.value?.response
                )
            }
            _uiStateEpisodesList.value = UiState.Loading
            getMoreEpisodesUseCase.execute(
                GetMoreEpisodesUseCase.Input(
                    request = _episodesList.value?.response?.info?.next?.split("=")?.last()?.toIntOrNull() ?: 1
                )
            ).catch { cause ->
                _episodesList.update {
                    error(cause.message ?: "Error")
                }
                _uiStateEpisodesList.value = UiState.Error(cause.message ?: "Error")
            }.collect { result ->

                result.response.success { response ->
                    _episodesList.update {
                        with(response) {
                            response.response?.results = (_episodesList.value?.response?.results
                                ?: emptyList()) + (response.response?.results ?: emptyList())
                            response
                        }
                    }
                    _uiStateEpisodesList.value = UiState.Success(response.response)
                }
                result.response.error { error ->
                    _episodesList.update {
                        with(_episodesList.value){
                            this?.status = StateApi.Success
                            this
                        }
                    }
                    "Algo salio mal ${error.failure}".log("ERROR")
                    _uiStateEpisodesList.value = UiState.Success(_episodesList.value?.response)
                }
            }
        }
    }


}