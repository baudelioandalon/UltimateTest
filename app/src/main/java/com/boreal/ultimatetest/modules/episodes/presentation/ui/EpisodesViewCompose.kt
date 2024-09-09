package com.boreal.ultimatetest.modules.episodes.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.boreal.ultimatetest.core.BuildConfig
import com.boreal.ultimatetest.core.domain.base.UiState
import com.boreal.ultimatetest.core.domain.base.reachedBottom
import com.boreal.ultimatetest.domain.model.characters.Endpoints
import com.boreal.ultimatetest.modules.episodes.domain.viewmodel.EpisodesViewModel
import com.boreal.ultimatetest.modules.locations.domain.viewmodel.LocationsViewModel
import com.boreal.ultimatetest.ui.components.ResultLocationItem
import com.boreal.ultimatetest.ui.theme.PrimaryColor


@Preview(showBackground = true)
@Composable
fun EpisodesViewCompose(
    navController: NavController? = null,
    episodesViewModel: EpisodesViewModel? = hiltViewModel()
) {

    val listResult = episodesViewModel?.uiStateEpisodesList?.collectAsStateWithLifecycle()?.value
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        episodesViewModel?.getEpisodesList()
    }

    val reachedBottom: Boolean by remember { derivedStateOf { listState.reachedBottom() } }

    // load more if scrolled to bottom
    LaunchedEffect(reachedBottom) {
        if (reachedBottom) episodesViewModel?.getMoreEpisodes()
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(White),
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
                    ResultLocationItem(
                        modifier = Modifier.padding(
                            vertical = 20.dp
                        ),
                        name = "Episode ${item.name} - ${item.episode}".take(20),
                        secondText = "personajes",
                        residents = item.characters?.map { "${BuildConfig.BASE_URL}${Endpoints.GET_AVATAR.url}${it.split("/").last()}.jpeg" } ?: emptyList(),
                        clicked = {

                        }
                    )

                }
            }
        }

    }

}