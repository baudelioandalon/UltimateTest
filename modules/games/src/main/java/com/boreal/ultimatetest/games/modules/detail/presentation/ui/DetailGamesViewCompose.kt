package com.boreal.ultimatetest.games.modules.detail.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.boreal.ultimatetest.core.components.BoldText
import com.boreal.ultimatetest.core.components.HorizontalImageViewer
import com.boreal.ultimatetest.core.components.MediumText
import com.boreal.ultimatetest.core.components.ToolbarTitle
import com.boreal.ultimatetest.core.ui.theme.GrayBackgroundDrawerDismiss
import com.boreal.ultimatetest.core.ui.theme.GrayBackgroundMain
import com.boreal.ultimatetest.core.ui.theme.GrayLetterShipping
import com.boreal.ultimatetest.core.ui.theme.SecondaryColorGames
import com.boreal.ultimatetest.games.components.HorizontalContainerListItem
import com.boreal.ultimatetest.games.components.SelectorDetail
import com.boreal.ultimatetest.games.components.SellerItem
import com.boreal.ultimatetest.games.components.SeparatorGray
import com.boreal.ultimatetest.games.components.ShareButton
import com.boreal.ultimatetest.games.domain.model.GamesResponseModel
import com.boreal.ultimatetest.games.domain.model.GamesResponseModelItem
import com.boreal.ultimatetest.uisystem.R

@Composable
fun DetailGamesViewCompose(
    navController: NavController? = null,
    dataToShow: GamesResponseModelItem? = null,
    allGames: GamesResponseModel? = null
) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        ToolbarTitle(titleText = "Videojuego",
            startClicked = {
                navController?.navigateUp()
            })
    }, bottomBar = {

    }, backgroundColor = SecondaryColorGames) {

        LazyColumn(
            modifier = Modifier
                .wrapContentWidth()
                .padding(it)
                .background(GrayBackgroundMain)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(), shape = RectangleShape, elevation = 5.dp
                ) {
                    Column {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            backgroundColor = GrayBackgroundDrawerDismiss,
                            elevation = 0.dp,
                            shape = RectangleShape
                        ) {
                            AsyncImage(
                                modifier = Modifier.fillMaxSize(),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(dataToShow?.thumbnail.orEmpty())
                                    .crossfade(true)
                                    .allowHardware(false)
                                    .build(),
                                placeholder = painterResource(R.drawable.portal),
                                contentDescription = stringResource(R.string.app_name),
                                contentScale = ContentScale.Crop
                            )
                        }

                        /**
                         * Previsualizador de imagenes horizontales
                         */
                        HorizontalImageViewer(modifier = Modifier.padding(vertical = 15.dp),
                            colorSelected = MaterialTheme.colors.primary,
                            itemList = allGames?.filter { it.genre == dataToShow?.genre }
                                ?.map { it.thumbnail } ?: emptyList(),
                            zoomWhenSelected = true,
                            itemClicked = { index, item ->

                            })

                        Row(
                            modifier = Modifier
                                .background(White)
                                .padding(end = 30.dp, start = 30.dp)
                                .fillMaxWidth()
                                .wrapContentHeight(unbounded = true)
                        ) {
                            BoldText(
                                modifier = Modifier.weight(1f),
                                text = dataToShow?.title.orEmpty(),
                                color = Black,
                                fontSize = 22.sp
                            )
                        }


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(top = 10.dp, end = 30.dp, start = 30.dp, bottom = 15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MediumText(
                                text = dataToShow?.short_description.orEmpty(),
                                fontSize = 10.sp,
                                color = GrayLetterShipping
                            )

                            ShareButton {

                            }
                        }



                        SelectorDetail(
                            text = "Ir a la pagina del videojuego"
                        ) {

                        }
                        SeparatorGray(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(White)
                                .padding(start = 30.dp, end = 30.dp)
                        )

                    }
                }

            }
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 45.dp),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {
                    HorizontalContainerListItem<Unit>(startText = "Publisher", bottomCompose = {
                        SellerItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, top = 22.dp, bottom = 15.dp),
                            topText = dataToShow?.publisher.orEmpty(),
                            bottomText = dataToShow?.developer.orEmpty()
                        ) {

                        }
                    })
                }

            }
            item {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp),
                    shape = RectangleShape,
                    elevation = 5.dp
                ) {
                    HorizontalImageViewer(modifier = Modifier.padding(vertical = 15.dp),
                        height = 150.dp,
                        width = 250.dp,
                        colorSelected = SecondaryColorGames,
                        itemList = allGames?.filter { it.platform == dataToShow?.platform }
                            ?.map { it.thumbnail } ?: emptyList(),
                        placeHolder = R.drawable.steam_icon_logo,
                        zoomWhenSelected = true,
                        itemClicked = { index, item ->

                        })
                }

            }
        }
    }


}