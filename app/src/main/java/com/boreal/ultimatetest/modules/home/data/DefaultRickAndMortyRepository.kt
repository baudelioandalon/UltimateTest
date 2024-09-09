package com.boreal.ultimatetest.modules.home.data

import com.boreal.ultimatetest.modules.home.data.get_list.GetListDataSource
import com.boreal.ultimatetest.modules.home.domain.interfaces.RickAndMortyRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultRickAndMortyRepository @Inject constructor(private val getListDataSource: GetListDataSource) :
    RickAndMortyRepository {

    override suspend fun executeGetList() = flow {
        emit(getListDataSource.executeGetList())
    }
}