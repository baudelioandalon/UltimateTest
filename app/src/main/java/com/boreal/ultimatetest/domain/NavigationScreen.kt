package com.boreal.ultimatetest.domain

import com.boreal.ultimatetest.uisystem.R

const val WELCOME_GRAPH = "WELCOME_GRAPH"
const val HOME_GRAPH = "HOME_GRAPH"
const val LOCATIONS_GRAPH = "LOCATIONS_GRAPH"
const val EPISODES_GRAPH = "EPISODES_GRAPH"

sealed class NavigationScreen(
    val route: String,
    val icon: Int = R.drawable.rick_and_morty_logo,
    val title: String = ""
) {
    data object WelcomeScreen : NavigationScreen("welcome_screen", R.drawable.rick_and_morty_logo, "")
    data object HomeScreen : NavigationScreen("home_screen", R.drawable.rick_and_morty_logo, "")
    data object LocationsScreen : NavigationScreen("locations_screen", R.drawable.location_pin, "Locations")
    data object EpisodesScreen : NavigationScreen("episodes_screen", R.drawable.episodes, "Episodes")
}