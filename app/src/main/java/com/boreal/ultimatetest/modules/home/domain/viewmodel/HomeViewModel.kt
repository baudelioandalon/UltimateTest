package com.boreal.ultimatetest.modules.home.domain.viewmodel

import androidx.compose.runtime.mutableStateOf
import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.base.BaseViewModel
import com.boreal.ultimatetest.core.domain.base.UiState
import com.boreal.ultimatetest.core.domain.base.log
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.core.domain.network.error
import com.boreal.ultimatetest.core.domain.network.loading
import com.boreal.ultimatetest.core.domain.network.success
import com.boreal.ultimatetest.domain.model.RickAndMortyResponseModel
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetListUseCase
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetMoreCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase,
    private val getMoreCharactersUseCase: GetMoreCharactersUseCase
) : BaseViewModel() {


    private val _characterList = MutableStateFlow<ApiResponse<RickAndMortyResponseModel>?>(null)
    private val _uiStateCharacterList = MutableStateFlow<UiState<RickAndMortyResponseModel?>>(UiState.None)
    val uiStateCharacterList: StateFlow<UiState<RickAndMortyResponseModel?>> = _uiStateCharacterList


    /**
     * @see Obtener la lista de personajes
     * @param Sin parametros de entrada
     * @return ApiResponse<RickAndMortyResponseModel>
     */
    fun getList() {
        executeFlow {
            if (_characterList.value?.status == StateApi.Loading || _characterList.value?.status == StateApi.Success) return@executeFlow
            _characterList.update {
                loading()
            }
            _uiStateCharacterList.value = UiState.Loading
            getListUseCase.execute(
                EmptyIn
            ).catch { cause ->
                _characterList.update {
                    error(cause.message ?: "Error")
                }
                _uiStateCharacterList.value = UiState.Error(cause.message ?: "Error")
            }.collect { result ->
                result.response.success { response ->
                    _characterList.update {
                        response
                    }
                    _uiStateCharacterList.value = UiState.Success(response.response)
                }
                result.response.error { error ->
                    _characterList.update {
                        error
                    }
                    _uiStateCharacterList.value = UiState.Error(error.failure ?: "Error")
                }
            }
        }
    }

    /**
     * @see Obtener más personajes de las paginas siguientes
     */
    fun getMore() {

        if (_characterList.value?.status == StateApi.Success && _characterList.value?.response?.info?.next.isNullOrEmpty()) {
            "No hay más personajes".log("MAX_RESULTS")
            return
        }
        executeFlow {
            delay(500)
            if (_characterList.value?.status == StateApi.Loading ) return@executeFlow
            _characterList.update {
                loading(
                    savedBundle = _characterList.value?.response
                )
            }
            _uiStateCharacterList.value = UiState.Loading
            getMoreCharactersUseCase.execute(
                GetMoreCharactersUseCase.Input(
                    request = _characterList.value?.response?.info?.next?.split("=")?.last()?.toIntOrNull() ?: 1
                )
            ).catch { cause ->
                _characterList.update {
                    error(cause.message ?: "Error")
                }
                _uiStateCharacterList.value = UiState.Error(cause.message ?: "Error")
            }.collect { result ->

                result.response.success { response ->
                    _characterList.update {
                        with(response) {
                            response.response?.results = (_characterList.value?.response?.results
                                ?: emptyList()) + (response.response?.results ?: emptyList())
                            response
                        }
                    }
                    _uiStateCharacterList.value = UiState.Success(response.response)
                }
                result.response.error { error ->
                    _characterList.update {
                        with(_characterList.value){
                            this?.status = StateApi.Success
                            this
                        }
                    }
                    "Algo salio mal ${error.failure}".log("ERROR")
                    _uiStateCharacterList.value = UiState.Success(_characterList.value?.response)
                }
            }
        }
    }


}