package com.boreal.ultimatetest.games.modules.edit_data.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.boreal.ultimatetest.core.components.EditTextTopLabel
import com.boreal.ultimatetest.core.components.LogoSmall
import com.boreal.ultimatetest.core.components.PrimaryButton
import com.boreal.ultimatetest.core.components.ToolbarTitle
import com.boreal.ultimatetest.core.ui.theme.GrayBackgroundDrawerDismiss
import com.boreal.ultimatetest.core.ui.theme.PrimaryColorGames
import com.boreal.ultimatetest.core.ui.theme.SecondaryColorGames
import com.boreal.ultimatetest.games.domain.model.GamesResponseModelItem
import com.boreal.ultimatetest.games.domain.navigation.NavigationGamesScreen
import com.boreal.ultimatetest.games.modules.edit_data.viewmodel.EditGamesViewModel
import com.boreal.ultimatetest.uisystem.R

@Composable
fun EditViewCompose(
    navController: NavController,
    dataToShow: GamesResponseModelItem? = null,
    editViewModel: EditGamesViewModel = hiltViewModel()
) {

    var titleText by rememberSaveable { mutableStateOf(dataToShow?.title.orEmpty()) }
    var descriptionText by rememberSaveable { mutableStateOf(dataToShow?.short_description.orEmpty()) }
    var genreText by rememberSaveable { mutableStateOf(dataToShow?.genre.orEmpty()) }
    var publisherText by rememberSaveable { mutableStateOf(dataToShow?.publisher.orEmpty()) }
    var releaseDateText by rememberSaveable { mutableStateOf(dataToShow?.release_date.orEmpty()) }

    val scrollRemember = rememberScrollState()

    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Editar datos",
            startClicked = {
                navController.popBackStack(NavigationGamesScreen.HomeGamesScreen.route, false)
            },
            showEndImage = false,
        )
    }) {
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(it)
                .verticalScroll(scrollRemember)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(200.dp),
                backgroundColor = GrayBackgroundDrawerDismiss,
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp)
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

            EditTextTopLabel(
                modifier = Modifier.padding(top = 31.dp),
                topLabelText = "Titulo",
                value = titleText,
                onValueChange = {
                    titleText = it
                },
                placeHolderText = dataToShow?.title.orEmpty(),
            )

            EditTextTopLabel(
                modifier = Modifier.padding(top = 26.dp),
                topLabelText = "Descripcion",
                value = descriptionText,
                onValueChange = {
                    descriptionText = it
                },
                placeHolderText = dataToShow?.short_description.orEmpty(),
            )
            EditTextTopLabel(
                modifier = Modifier.padding(top = 26.dp),
                topLabelText = "Genero",
                value = genreText,
                onValueChange = {
                    genreText = it
                },
                placeHolderText = dataToShow?.genre.orEmpty(),
            )
            EditTextTopLabel(
                modifier = Modifier.padding(top = 26.dp),
                topLabelText = "Publicador",
                value = publisherText,
                onValueChange = {
                    publisherText = it
                },
                placeHolderText = dataToShow?.publisher.orEmpty(),
            )

            EditTextTopLabel(
                modifier = Modifier.padding(top = 26.dp),
                topLabelText = "Fecha de lanzamiento",
                value = releaseDateText,
                onValueChange = {
                    releaseDateText = it
                },
                placeHolderText = dataToShow?.release_date.orEmpty(),
            )

            PrimaryButton(
                modifier = Modifier.padding(top = 40.dp),
                text = "Guardar",
                primaryColor = PrimaryColorGames,
                secondaryColor = SecondaryColorGames,
                enabled = titleText.isNotEmpty() && titleText != dataToShow?.title ||
                        descriptionText.isNotEmpty() && descriptionText != dataToShow?.short_description ||
                        genreText.isNotEmpty() && genreText != dataToShow?.genre ||
                        publisherText.isNotEmpty() && publisherText != dataToShow?.publisher ||
                        releaseDateText.isNotEmpty() && releaseDateText != dataToShow?.release_date
            ) {
                editViewModel.updateData(
                    titleText = titleText,
                    descriptionText = descriptionText,
                    genreText = genreText,
                    publisherText = publisherText,
                    releaseDateText = releaseDateText,
                    idElement = dataToShow?.id ?: -1
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )

            LogoSmall(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 10.dp)
                    .width(75.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                icon = R.drawable.games_controller_icon
            )
        }
    }

}