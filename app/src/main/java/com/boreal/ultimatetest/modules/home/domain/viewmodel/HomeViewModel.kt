package com.boreal.ultimatetest.modules.home.domain.viewmodel

import com.boreal.ultimatetest.core.domain.EmptyIn
import com.boreal.ultimatetest.core.domain.base.BaseViewModel
import com.boreal.ultimatetest.core.domain.network.ApiResponse
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.core.domain.network.error
import com.boreal.ultimatetest.core.domain.network.loading
import com.boreal.ultimatetest.core.domain.network.success
import com.boreal.ultimatetest.domain.model.RickAndMortyResponseModel
import com.boreal.ultimatetest.modules.home.domain.use_cases.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase
) : BaseViewModel() {

    private val _characterList =
        MutableStateFlow<ApiResponse<RickAndMortyResponseModel>?>(null)
    val characterList = _characterList.asStateFlow()

    fun getList() {
        executeFlow {
            if (_characterList.value?.status == StateApi.Loading || _characterList.value?.status == StateApi.Success) return@executeFlow
            _characterList.update {
                loading()
            }
            getListUseCase.execute(
                EmptyIn
            ).catch { cause ->
                _characterList.update {
                    error(cause.message ?: "Error")
                }
            }.collect { result ->

                result.response.success { response ->
                    _characterList.update {
                        response
                    }
                }
                result.response.error { error ->
                    _characterList.update {
                        error
                    }
                }
            }
        }
    }

}