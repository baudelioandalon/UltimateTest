package com.boreal.ultimatetest.modules.home.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.boreal.ultimatetest.core.domain.network.StateApi
import com.boreal.ultimatetest.modules.home.domain.viewmodel.HomeViewModel
import com.boreal.ultimatetest.ui.components.ResultItem
import com.boreal.ultimatetest.ui.theme.ErrorColor
import com.boreal.ultimatetest.ui.theme.GreenStrong
import com.boreal.ultimatetest.ui.theme.PrimaryColor

@Preview(showBackground = true)
@Composable
fun HomeViewCompose(
    navController: NavController? = null,
    homeViewModel: HomeViewModel? = hiltViewModel()
) {

    val listResult = homeViewModel?.characterList?.collectAsStateWithLifecycle()?.value

    LaunchedEffect(Unit) {
        homeViewModel?.getList()
    }

    AnimatedVisibility(listResult?.status == StateApi.Loading) {
        CircularProgressIndicator(modifier = Modifier.size(50.dp), color = Color.Blue)
    }

    Scaffold(topBar = {

    }) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(White),
            columns = GridCells.Fixed(2)
        ) {

            itemsIndexed(
                items = if (listResult?.status == StateApi.Success) {
                    listResult.response?.results ?: emptyList()
                } else {
                    emptyList()
                }
            ) { index, item ->
                ResultItem(
                    modifier = Modifier.padding(
                        start = if (index % 2 == 0) 30.dp else 10.dp,
                        end = if (index % 2 == 0) 10.dp else 30.dp,
                        top = if (index % 2 != 0) 20.dp else 0.dp
                    ),
                    model = item,
                    clicked = {

                    },
                    statusColor = when (item.status.uppercase()) {
                        "ALIVE" -> {
                            GreenStrong
                        }

                        "DEAD" -> {
                            ErrorColor
                        }

                        else -> {
                            PrimaryColor
                        }
                    }
                )
            }
        }
    }

}