package com.boreal.ultimatetest.core.domain.base

sealed class UiState<out T> {

    data class Success<T>(val data: T?) : UiState<T>()

    data class Error<T>(val message: String) : UiState<T>()

    data object Loading : UiState<Nothing>()
    data object None : UiState<Nothing>()

}