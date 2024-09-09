package com.boreal.ultimatetest.modules.home.presentation.ui

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
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.boreal.ultimatetest.core.domain.base.UiState
import com.boreal.ultimatetest.domain.model.CharacterStatus
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

    val listResult = homeViewModel?.uiStateCharacterList?.collectAsStateWithLifecycle()?.value
    val listState = rememberLazyGridState()

    val isAtBottom by remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val visibleItemsInfo = layoutInfo.visibleItemsInfo
            if (layoutInfo.totalItemsCount == 0) {
                false
            } else {
                val lastVisibleItem = visibleItemsInfo.last()
                val viewportHeight = layoutInfo.viewportEndOffset + layoutInfo.viewportStartOffset

                (lastVisibleItem.index + 1 == layoutInfo.totalItemsCount &&
                        lastVisibleItem.offset.y + lastVisibleItem.size.height <= viewportHeight)
            }
        }
    }

    LaunchedEffect(Unit) {
        homeViewModel?.getList()
    }

    Scaffold(topBar = {

    }) {

        if (listResult == UiState.Loading) {
            AnimatedVisibility(listResult == UiState.Loading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp), color = PrimaryColor)
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
                            CharacterStatus.ALIVE.name -> {
                                GreenStrong
                            }

                            CharacterStatus.DEAD.name -> {
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


        if (isAtBottom) {
            homeViewModel?.getMore()
        }
    }

}