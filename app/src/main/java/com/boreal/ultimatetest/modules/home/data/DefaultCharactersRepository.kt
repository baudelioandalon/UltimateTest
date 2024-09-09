package com.boreal.ultimatetest.modules.home.data

import com.boreal.ultimatetest.modules.home.data.get_characteres.GetListCharactersDataSource
import com.boreal.ultimatetest.modules.home.domain.interfaces.CharactersRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultCharactersRepository @Inject constructor(private val getListCharactersDataSource: GetListCharactersDataSource) :
    CharactersRepository {

    override suspend fun executeGetList() = flow {
        emit(getListCharactersDataSource.executeGetList())
    }

    override suspend fun executeGetMoreCharacters(page: Int) = flow {
        emit(getListCharactersDataSource.executeGetMore(page))
    }
}