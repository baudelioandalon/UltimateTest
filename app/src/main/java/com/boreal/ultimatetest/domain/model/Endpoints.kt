package com.boreal.ultimatetest.domain.model

enum class Endpoints(val url: String) {
    GET_LIST("api/character"),
    GET_MORE("api/character?page="),
}