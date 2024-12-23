package com.boreal.ultimatetest.games.modules.home.viewmodel

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.base.BaseViewModel
import com.boreal.ultimatetest.core.domain.base.UiState
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.core.domain.network.error
import com.boreal.ultimatetest.core.domain.network.loading
import com.boreal.ultimatetest.core.domain.network.success
import com.boreal.ultimatetest.games.domain.model.GamesResponseModel
import com.boreal.ultimatetest.games.domain.use_cases.GetListGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeGamesViewModel @Inject constructor(
    private val getListCharactersUseCase: GetListGamesUseCase
) : BaseViewModel() {


    private val _gameList = MutableStateFlow<ApiResponse<GamesResponseModel>?>(null)
    private val _uiStateGamesList = MutableStateFlow<UiState<GamesResponseModel?>>(UiState.None)
    val uiStateGamesList: StateFlow<UiState<GamesResponseModel?>> = _uiStateGamesList

    private var gameSelectedItem = -1

    /**
     * @see Obtener la lista de videojuegos
     * @param Sin parametros de entrada
     * @return ApiResponse<GamesResponseModel>
     */
    fun getList() {
        executeFlow {
            if (_gameList.value?.status == StateApi.Loading || _gameList.value?.status == StateApi.Success) return@executeFlow
            _gameList.update {
                loading()
            }
            _uiStateGamesList.value = UiState.Loading
            getListCharactersUseCase.execute(
                EmptyIn
            ).catch { cause ->
                _gameList.update {
                    error(cause.message ?: "Error")
                }
                _uiStateGamesList.value = UiState.Error(cause.message ?: "Error")
            }.collect { result ->
                result.response.success { response ->
                    _gameList.update {
                        response
                    }
                    _uiStateGamesList.value = UiState.Success(response.response)
                }
                result.response.error { error ->
                    _gameList.update {
                        error
                    }
                    _uiStateGamesList.value = UiState.Error(error.failure ?: "Error")
                }
            }
        }
    }

    fun setGameSelected(position: Int) {
        gameSelectedItem = position
    }


}