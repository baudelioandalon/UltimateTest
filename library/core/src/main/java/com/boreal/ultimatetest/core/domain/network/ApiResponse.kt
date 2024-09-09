package com.boreal.ultimatetest.core.domain.network


data class ApiResponse<T>(
    val response: T? = null,
    val failure: String? = null,
    var status: StateApi = StateApi.None
)

// Extension function to check if the status is success
fun <T> ApiResponse<T>.success(result: (ApiResponse<T>) -> Unit) {
    if (status == StateApi.Success) {
        result(this)
    }
}

// Extension function to create a loading state
fun <T> loading() = ApiResponse<T>(
    status = StateApi.Loading
)

// Extension function to check if the status is error
fun <T> ApiResponse<T>.error(result: (ApiResponse<T>) -> Unit) {
    if (status == StateApi.Error) {
        result(this)
    }
}