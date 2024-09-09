package com.boreal.ultimatetest.domain.model.characters

enum class Endpoints(val url: String) {
    GET_CHARACTERS_LIST("api/character"),
    GET_MORE_CHARACTERS("api/character?page="),
    GET_LOCATIONS_LIST("api/location"),
    GET_MORE_LOCATIONS("api/location?page="),
    GET_EPISODES_LIST("api/episode"),
    GET_MORE_EPISODES("api/episode?page="),
    GET_AVATAR("api/character/avatar/")
}