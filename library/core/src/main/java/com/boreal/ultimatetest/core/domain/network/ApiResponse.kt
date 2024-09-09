package com.boreal.ultimatetest.core.domain.network


data class ApiResponse<T>(
    val response: T? = null,
    val failure: String? = null,
    var status: StateApi = StateApi.None
)

fun <T> ApiResponse<T>.success(result: (ApiResponse<T>) -> Unit) {
    if (status == StateApi.Success) {
        result(this)
    }
}

fun <T> loading() = ApiResponse<T>(
    status = StateApi.Loading
)

fun <T> ApiResponse<T>.error(result: (ApiResponse<T>) -> Unit) {
    if (status == StateApi.Error) {
        result(this)
    }
}