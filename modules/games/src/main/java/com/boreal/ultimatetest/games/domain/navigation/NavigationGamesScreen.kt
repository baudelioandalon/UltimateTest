package com.boreal.ultimatetest.games.domain.navigation

import com.boreal.ultimatetest.uisystem.R


sealed class NavigationGamesScreen(
    val route: String,
    val icon: Int = R.drawable.rick_and_morty_logo,
    val title: String = ""
) {
    data object WelcomeGamesScreen : NavigationGamesScreen("welcome_games_screen", R.drawable.steam_icon_logo, "")
    data object HomeGamesScreen : NavigationGamesScreen("home_games_screen", R.drawable.steam_icon_logo, "")
    data object DetailGamesScreen : NavigationGamesScreen("detail_games_screen", R.drawable.steam_icon_logo, "")
    data object EditGamesScreen : NavigationGamesScreen("edit_games_screen", R.drawable.steam_icon_logo, "")
}