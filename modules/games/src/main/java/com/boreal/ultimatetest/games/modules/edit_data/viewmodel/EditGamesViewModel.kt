package com.boreal.ultimatetest.games.modules.edit_data.viewmodel

import com.boreal.ultimatetest.core.domain.base.BaseViewModel
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto
import com.boreal.ultimatetest.games.domain.model.GamesResponseModelItem
import com.boreal.ultimatetest.games.domain.use_cases.DeleteGameUseCase
import com.boreal.ultimatetest.games.domain.use_cases.SetUpdateGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EditGamesViewModel @Inject constructor(
    private val setUpdateGameUseCase: SetUpdateGameUseCase,
    private val deleteGameUseCase: DeleteGameUseCase
) : BaseViewModel() {


    private val _updateGame = MutableStateFlow<StateApi?>(null)
    private val _deleteGame = MutableStateFlow<StateApi?>(null)
    val updateGame: StateFlow<StateApi?> = _updateGame.asStateFlow()
    val deleteGame: StateFlow<StateApi?> = _deleteGame.asStateFlow()


    /**
     * @see Actualizar el videojuego localmente
     * @param titleText: String
     * @param descriptionText: String
     * @param genreText: String
     * @param publisherText: String
     * @param releaseDateText: String
     * @param idElement: Int
     * @return ApiResponse<GamesResponseModel>
     */
    fun updateData(
        item: GamesResponseModelItem?,
        titleText: String,
        descriptionText: String,
        genreText: String,
        publisherText: String,
        releaseDateText: String
    ) {
        executeFlow {
            if (_updateGame.value == StateApi.Loading || _updateGame.value == StateApi.Success) return@executeFlow
            _updateGame.update {
                StateApi.Loading
            }
            setUpdateGameUseCase.execute(
                SetUpdateGameUseCase.Input(
                    game = GamesModelItemDto(
                        id = item?.id ?: 0,
                        title = titleText,
                        short_description = descriptionText,
                        genre = genreText,
                        publisher = publisherText,
                        release_date = releaseDateText,
                        thumbnail = item?.thumbnail.orEmpty(),
                        platform = item?.platform.orEmpty(),
                        freetogame_profile_url = item?.freetogame_profile_url.orEmpty(),
                        game_url = item?.game_url.orEmpty(),
                        developer = item?.developer.orEmpty()
                    )
                )
            ).catch { cause ->
                _updateGame.update {
                    error(cause.message ?: "Error")
                }
            }.collect { result ->
                if (result.response == StateApi.Success) {
                    _updateGame.update {
                        result.response
                    }
                } else if (result.response == StateApi.Error) {
                    _updateGame.update {
                        result.response
                    }
                }
            }
        }
    }

    fun deleteItem(
        itemId: Int
    ) {
        executeFlow {
            if (_deleteGame.value == StateApi.Loading || _deleteGame.value == StateApi.Success) return@executeFlow
            _deleteGame.update {
                StateApi.Loading
            }
            deleteGameUseCase.execute(
                DeleteGameUseCase.Input(
                    gameId = itemId
                )
            ).catch { cause ->
                _deleteGame.update {
                    error(cause.message ?: "Error")
                }
            }.collect { result ->
                if (result.response == StateApi.Success) {
                    _deleteGame.update {
                        result.response
                    }
                } else if (result.response == StateApi.Error) {
                    _deleteGame.update {
                        result.response
                    }
                }
            }
        }
    }


}