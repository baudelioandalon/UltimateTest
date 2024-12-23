package com.boreal.ultimatetest.games.modules.home.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.boreal.ultimatetest.core.components.BoldText
import com.boreal.ultimatetest.core.components.HorizontalImageViewer
import com.boreal.ultimatetest.core.domain.EMPTY_STRING
import com.boreal.ultimatetest.core.domain.base.UiState
import com.boreal.ultimatetest.core.domain.base.log
import com.boreal.ultimatetest.core.ui.theme.SecondaryColorGames
import com.boreal.ultimatetest.core.ui.theme.categorySelectorColors
import com.boreal.ultimatetest.core.utils.limit
import com.boreal.ultimatetest.games.components.CategorySelectorItem
import com.boreal.ultimatetest.games.components.ToolbarSearch
import com.boreal.ultimatetest.games.modules.home.viewmodel.HomeGamesViewModel
import com.boreal.ultimatetest.uisystem.R
import java.util.Locale


@Preview(showBackground = true)
@Composable
fun HomeGamesViewCompose(
    navController: NavController? = null,
    homeViewModel: HomeGamesViewModel? = hiltViewModel(),
    primaryColor: Color = Black,
    secondaryColor: Color = Black,
    aliveColor: Color = Black,
    deadColor: Color = Black
) {

    val listResult = homeViewModel?.uiStateGamesList?.collectAsStateWithLifecycle()?.value
    var searchedText by remember { mutableStateOf(EMPTY_STRING) }
    var categorySelected by remember { mutableStateOf(EMPTY_STRING) }

    LaunchedEffect(Unit) {
        homeViewModel?.getList()
    }

    Scaffold(topBar = {
        ToolbarSearch(primaryColor = SecondaryColorGames,
            searchedText = {
                searchedText = it
            })
    }) {

        if (listResult == UiState.Loading) {
            AnimatedVisibility(listResult == UiState.Loading) {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp), color = primaryColor)
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .background(
                        color = White,
                        shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                    )
            ) {
                //Categorias
                item {
                    CategoryListContainer(itemCategory = if (listResult is UiState.Success) {
                        val list = listResult.data?.groupBy { it.genre }
                            ?.map { it.key.orEmpty().trim() } ?: emptyList()
                        list
                    } else emptyList()) { selectedString, selectedIndex ->
                        "$selectedString -> $selectedIndex".log("TEXT")
                        if (selectedIndex == -1) {
                            categorySelected = EMPTY_STRING
                        } else {
                            categorySelected = selectedString
                        }
                    }
                }

                //Lista de videojuegos
                itemsIndexed(items = if (listResult is UiState.Success) {
                    if (searchedText.isNotEmpty()) {
                        if (categorySelected.isNotEmpty()) {
                            listResult.data?.sortedWith(compareBy {
                                it.title.lowercase().contains(searchedText.lowercase())
                            })?.filter {
                                it.title.lowercase().contains(searchedText.lowercase())
                            }
                                ?.groupBy { it.genre }?.map { it.key.orEmpty().trim() }
                                ?.filter { it == categorySelected } ?: emptyList()
                        } else {
                            listResult.data?.sortedWith(compareBy {
                                it.title.lowercase().contains(searchedText.lowercase())
                            })?.filter {
                                it.title.lowercase().contains(searchedText.lowercase())
                            }
                                ?.groupBy { it.genre }?.map { it.key.orEmpty().trim() }
                                ?: emptyList()
                        }
                    } else {
                        if (categorySelected.isNotEmpty()) {
                            listResult.data?.groupBy { it.genre }?.map { it.key.orEmpty().trim() }
                                ?.filter { it == categorySelected }
                                ?: emptyList()
                        } else {
                            listResult.data?.groupBy { it.genre }?.map { it.key.orEmpty().trim() }
                                ?: emptyList()
                        }

                    }
                } else emptyList()) { index, item ->
                    BoldText(
                        modifier = Modifier
                            .background(White)
                            .padding(start = 30.dp),
                        text = item.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                        color = Black,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp
                    )

                    HorizontalImageViewer(modifier = Modifier.padding(vertical = 15.dp),
                        height = 150.dp,
                        width = 250.dp,
                        colorSelected = secondaryColor,
                        itemList = if (listResult is UiState.Success) {
                            if (searchedText.isNotEmpty()) {
                                listResult.data?.sortedWith(compareBy {
                                    it.title.lowercase().contains(searchedText.lowercase())
                                })?.filter { it.genre == item }?.map { it.thumbnail }?.reversed()
                                    ?: emptyList()
                            } else {
                                listResult.data?.filter { it.genre == item }?.map { it.thumbnail }
                                    ?: emptyList()
                            }
                        } else {
                            emptyList()
                        },
                        placeHolder = R.drawable.steam_icon_logo,
                        zoomWhenSelected = true,
                        itemClicked = { index, item ->
                            if (listResult is UiState.Success) {
                                val imageSelected =
                                    listResult?.data?.find { it.thumbnail == item }?.id
                                imageSelected?.toString()?.log("IMG_SELECTED")
                                homeViewModel?.setGameSelected(imageSelected ?: -1)
//                                navController?.navigate(NavigationGamesScreen.DetailGamesScreen.route)
                            }

                        })
                }
            }
        }
    }
}


@Composable
fun CategoryListContainer(
    itemCategory: List<String> = emptyList(),
    categorySelected: (String, Int) -> Unit
) {
    var itemCategorySelected by rememberSaveable { mutableIntStateOf(-1) }
    val defaultSize = if (itemCategorySelected != -1) 50.dp.plus(15.dp) else 50.dp
    Column(
        modifier = Modifier.background(White)
    ) {
        LazyRow(
            modifier = Modifier.padding(
                top = 15.dp, bottom = 18.dp
            )
        ) {
            itemsIndexed(items = itemCategory) { index, item ->
                CategorySelectorItem(
                    modifier = Modifier.padding(
                        start = if (index == 0) 30.dp else 10.dp,
                        end = if (index == itemCategory.limit()) 30.dp else 10.dp
                    ),
                    size = if (itemCategorySelected == index) defaultSize else 50.dp,
                    category = item,
                    color = categorySelectorColors[index % categorySelectorColors.size]
                ) {
                    itemCategorySelected = if (index == itemCategorySelected) -1 else index
                    categorySelected(item, itemCategorySelected)
                }
            }
        }
    }
}