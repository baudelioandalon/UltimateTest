package com.boreal.ultimatetest.modules.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boreal.ultimatetest.domain.model.CharacterModel
import com.boreal.ultimatetest.domain.model.Location
import com.boreal.ultimatetest.domain.model.Origin
import com.boreal.ultimatetest.ui.components.ResultItem
import com.boreal.ultimatetest.ui.theme.ErrorColor
import com.boreal.ultimatetest.ui.theme.GreenStrong
import com.boreal.ultimatetest.ui.theme.PrimaryColor

@Preview(showBackground = true)
@Composable
fun HomeViewCompose(
    navController: NavController? = null,
) {

    Scaffold(topBar = {
//        ToolbarSearchHome(
//            startIcon = "ic_back_arrow",
//            textPlaceHolder = searchProductViewModel.getFilterSearched(),
//            startClicked = {
//                searchProductViewModel.resetResults()
//                navController.popBackStack()
//            }, cartClicked = {
//            }, searchClicked = {
//            })
    }) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(White),
            columns = GridCells.Fixed(2)
        ) {

            itemsIndexed(
                items = listOf(
                    CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ),
                    CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Dead",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ),
                    CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Unknown",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ),
                    CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ), CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ), CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ), CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ), CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ), CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Dead",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ), CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    ), CharacterModel(
                        id = 1,
                        name = "Character 1",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        status = "Alive",
                        species = "Human",
                        gender = "Woman",
                        origin = Origin(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/1"
                        ),
                        location = Location(
                            name = "Earth",
                            url = "https://rickandmortyapi.com/api/location/20"
                        ),
                        episode = listOf("https://rickandmortyapi.com/api/episode/1"),
                        type = "Human",
                        url = "https://rickandmortyapi.com/api/character/1",
                        created = "2017-11-04T18:48:46.250Z"
                    )
                )
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