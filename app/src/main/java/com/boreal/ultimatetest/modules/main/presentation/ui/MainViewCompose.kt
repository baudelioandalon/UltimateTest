package com.boreal.ultimatetest.modules.main.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.boreal.ultimatetest.domain.NavigationScreen
import com.boreal.ultimatetest.modules.episodes.domain.viewmodel.EpisodesViewModel
import com.boreal.ultimatetest.modules.episodes.presentation.ui.EpisodesViewCompose
import com.boreal.ultimatetest.modules.home.domain.viewmodel.HomeViewModel
import com.boreal.ultimatetest.modules.home.presentation.ui.HomeViewCompose
import com.boreal.ultimatetest.modules.locations.domain.viewmodel.LocationsViewModel
import com.boreal.ultimatetest.modules.locations.presentation.ui.LocationViewCompose
import com.boreal.ultimatetest.modules.welcome.presentation.ui.WelcomeViewCompose
import com.boreal.ultimatetest.ui.components.bottomnavigation.CustomBottomNavigation

@Preview(showBackground = true)
@Composable
fun MainViewCompose() {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val currentScreen = remember { mutableStateOf<NavigationScreen>(NavigationScreen.HomeScreen) }
    var showBottomBar by rememberSaveable { mutableStateOf(false) }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    LaunchedEffect(currentBackStackEntry) {
        currentBackStackEntry?.destination?.route?.let { route ->
            showBottomBar = route != NavigationScreen.WelcomeScreen.route
        }
    }

    val homeViewModel: HomeViewModel = hiltViewModel()
    val locationsViewModel: LocationsViewModel = hiltViewModel()
    val episodesViewModel: EpisodesViewModel = hiltViewModel()

    androidx.compose.material.Scaffold(modifier = Modifier
        .fillMaxWidth(),
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        scaffoldState = scaffoldState,
        bottomBar = {
            if (showBottomBar) {
                CustomBottomNavigation(currentScreenId = currentScreen.value.route) {
                    val listNavigation =
                        navController.backQueue.map { it.destination.route }
                    if (it.route != currentScreen.value.route && !listNavigation.contains(it.route)) {
                        currentScreen.value = it
                        navController.navigate(it.route)
                    } else if (it.route != currentScreen.value.route && listNavigation.contains(it.route)) {
                        currentScreen.value = it
                        navController.popBackStack(it.route, false)
                    }
                }
            } else {
                Spacer(modifier = Modifier.padding(0.dp))
            }
        },
        content = {
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = NavigationScreen.WelcomeScreen.route
            ) {

                composable(route = NavigationScreen.WelcomeScreen.route) {
                    WelcomeViewCompose(
                        navController = navController
                    )
                }
                composable(route = NavigationScreen.HomeScreen.route) {
                    HomeViewCompose(
                        navController = navController,
                        homeViewModel = homeViewModel
                    )
                }
                composable(route = NavigationScreen.LocationsScreen.route) {
                    LocationViewCompose(
                        navController = navController,
                        locationsViewModel = locationsViewModel
                    )
                }
                composable(route = NavigationScreen.EpisodesScreen.route) {
                    EpisodesViewCompose(
                        navController = navController,
                        episodesViewModel = episodesViewModel
                    )
                }
            }
        })
}
