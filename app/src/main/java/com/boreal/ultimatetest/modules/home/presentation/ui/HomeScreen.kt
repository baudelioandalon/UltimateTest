package com.boreal.ultimatetest.modules.home.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boreal.ultimatetest.domain.NavigationScreen
import com.boreal.ultimatetest.ui.components.bottomnavigation.CustomBottomNavigation

@Preview(showBackground = true)
@Composable
fun HomeScreen() {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val currentScreen = remember { mutableStateOf<NavigationScreen>(NavigationScreen.HomeScreen) }


    androidx.compose.material.Scaffold(modifier = Modifier
        .fillMaxWidth(),
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        scaffoldState = scaffoldState,
        bottomBar = {
            CustomBottomNavigation(currentScreenId = currentScreen.value.route) {
                currentScreen.value = it
                navController.navigate(it.route)
            }
        },
        content = {
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = NavigationScreen.HomeScreen.route
            ) {
                composable(route = NavigationScreen.HomeScreen.route) {
//                        ViewHomeSellerCompose(
//                            scaffoldState = scaffoldState,
//                            scope = scope,
//                            navController = innerSellerNavController
//                        )
                }
                composable(route = NavigationScreen.LocationsScreen.route) {
//                        ViewMyProductsSellerCompose(
//                            navController = innerSellerNavController,
//                            scaffoldState = scaffoldState,
//                            scope = scope,
//                            closeApp = closeApp
//                        )
                }
                composable(route = NavigationScreen.EpisodesScreen.route) {
//                        ViewMyProductsSellerCompose(
//                            navController = innerSellerNavController,
//                            scaffoldState = scaffoldState,
//                            scope = scope,
//                            closeApp = closeApp
//                        )
                }
            }
        })
}
