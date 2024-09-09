package com.boreal.ultimatetest.core.domain.network

sealed class StateApi {
    data object Loading : StateApi()
    data object Success : StateApi()
    data object Error : StateApi() {
        var message: String? = null
        fun error(message: String): Error {
            Error.message = message
            return this
        }
    }

    data object None : StateApi()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[]"
            is Loading -> "Loading[]"
            is None -> ""
            is Error -> message.orEmpty()
        }
    }
}