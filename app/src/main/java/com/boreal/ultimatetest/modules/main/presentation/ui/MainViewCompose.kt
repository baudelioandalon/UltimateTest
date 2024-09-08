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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.boreal.ultimatetest.domain.NavigationScreen
import com.boreal.ultimatetest.modules.home.presentation.ui.HomeViewCompose
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

    androidx.compose.material.Scaffold(modifier = Modifier
        .fillMaxWidth(),
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        scaffoldState = scaffoldState,
        bottomBar = {
            if (showBottomBar) {
                CustomBottomNavigation(currentScreenId = currentScreen.value.route) {
                    currentScreen.value = it
                    navController.navigate(it.route)
                }
            } else {
                Spacer(modifier = Modifier.padding(0.dp))
            }
        },
        content = {
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = NavigationScreen.HomeScreen.route
            ) {
                composable(route = NavigationScreen.WelcomeScreen.route) {
                    WelcomeViewCompose(
                        navController = navController
                    )
                }
                composable(route = NavigationScreen.HomeScreen.route) {
                    HomeViewCompose(
                        navController = navController
                    )
                }
                composable(route = NavigationScreen.LocationsScreen.route) {
                }
                composable(route = NavigationScreen.EpisodesScreen.route) {
                }
            }
        })
}
