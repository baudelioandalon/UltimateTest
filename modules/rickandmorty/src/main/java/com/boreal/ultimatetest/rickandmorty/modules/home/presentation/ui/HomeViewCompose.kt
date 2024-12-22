package com.boreal.ultimatetest.rickandmorty.modules.home.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.boreal.ultimatetest.core.domain.base.UiState
import com.boreal.ultimatetest.core.domain.base.reachedBottom
import com.boreal.ultimatetest.rickandmorty.components.ResultCharacterItem
import com.boreal.ultimatetest.rickandmorty.domain.model.CharacterStatus
import com.boreal.ultimatetest.rickandmorty.modules.home.viewmodel.HomeViewModel


@Preview(showBackground = true)
@Composable
fun HomeViewCompose(
    navController: NavController? = null,
    homeViewModel: HomeViewModel? = hiltViewModel(),
    primaryColor: Color = Black,
    secondaryColor: Color = Black,
    aliveColor: Color = Black,
    deadColor: Color = Black
) {

    val listResult = homeViewModel?.uiStateCharacterList?.collectAsStateWithLifecycle()?.value
    val listState = rememberLazyGridState()

    LaunchedEffect(Unit) {
        homeViewModel?.getList()
    }

    val reachedBottom: Boolean by remember { derivedStateOf { listState.reachedBottom() } }

    // load more if scrolled to bottom
    LaunchedEffect(reachedBottom) {
        if (reachedBottom) homeViewModel?.getMore()
    }

    Scaffold(topBar = {

    }) {

        if (listResult == UiState.Loading) {
            AnimatedVisibility(listResult == UiState.Loading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp), color = primaryColor)
                }
            }
        } else {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(White),
                columns = GridCells.Fixed(2),
                state = listState
            ) {
                itemsIndexed(
                    items = when (listResult) {
                        is UiState.Success -> {
                            listResult.data?.results ?: emptyList()
                        }

                        else -> {
                            emptyList()
                        }
                    },
                    key = { _, item -> item.id }
                ) { index, item ->

                    ResultCharacterItem(
                        modifier = Modifier.padding(
                            start = if (index % 2 == 0) 30.dp else 10.dp,
                            end = if (index % 2 == 0) 10.dp else 30.dp,
                            top = if (index % 2 != 0) 20.dp else 0.dp
                        ),
                        model = item,
                        clicked = {

                        },
                        statusColor = when (item.status.uppercase()) {
                            CharacterStatus.ALIVE.name -> {
                                aliveColor
                            }

                            CharacterStatus.DEAD.name -> {
                                deadColor
                            }

                            else -> {
                                primaryColor
                            }
                        }
                    )

                }
            }
        }

    }

}