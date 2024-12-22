package com.boreal.ultimatetest.games.modules.welcome.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.boreal.ultimatetest.core.components.BoldText
import com.boreal.ultimatetest.core.components.LogoSmall
import com.boreal.ultimatetest.core.components.OutlinedText
import com.boreal.ultimatetest.core.components.PrimaryButton
import com.boreal.ultimatetest.core.domain.EMPTY_STRING
import com.boreal.ultimatetest.core.ui.theme.PrimaryColorGames
import com.boreal.ultimatetest.core.ui.theme.SecondaryColorGames
import com.boreal.ultimatetest.core.ui.theme.mediumTypo
import com.boreal.ultimatetest.games.BuildConfig
import com.boreal.ultimatetest.uisystem.R

@Preview(showBackground = true)
@Composable
fun WelcomeGamesViewCompose(
    navController: NavController? = null,
    primaryColor: Color = PrimaryColorGames,
    secondaryColor: Color = SecondaryColorGames,
    toHomeRoute: String = EMPTY_STRING
) {

    val scrollRemember = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollRemember)
            .background(White)
    ) {
        Image(
            modifier = Modifier
                .padding(top = 100.dp, bottom = 49.dp)
                .width(300.dp)
                .height(200.dp),
            painter = painterResource(id = R.drawable.steam_icon_logo),
            contentDescription = "logo image"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            BoldText(
                text = "Bienvenido a tu",
                color = Black,
                fontSize = 30.sp
            )
            OutlinedText(
                modifier = Modifier.padding(bottom = 30.dp),
                text = "Tienda de videojuegos",
                outlineWidth = 10f,
                fontSize = 70.sp,
                color = PrimaryColorGames,
                outlineColor = SecondaryColorGames
            )

            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Black,
                        fontSize = 14.sp,
                        fontWeight = Medium,
                        fontFamily = mediumTypo()
                    )
                ) {
                    append(
                        "En la siguiente pantalla se comenzará a usar las peticiones al servidor "
                    )
                }
                // We attach this *termsClick* annotation to the following content
                // until `pop()` is called
                pushStringAnnotation(
                    tag = "termsClick",
                    annotation = "termsClick"
                )
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp,
                        fontFamily = mediumTypo()
                    )
                ) {
                    append(BuildConfig.BASE_URL)
                }
                pop()
            }
            ClickableText(
                text = annotatedText,
                modifier = Modifier.padding(top = 27.dp),
                onClick = { offset ->

                }
            )

            PrimaryButton(
                modifier = Modifier.padding(top = 40.dp),
                text = "Entrar",
                primaryColor = primaryColor,
                secondaryColor = secondaryColor
            ) {
                navController?.navigate(toHomeRoute)
            }

            LogoSmall(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 10.dp)
                    .width(75.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                icon = R.drawable.games_controller_icon
            )

            OutlinedText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(end = 160.dp),
                text = "Dreams Gaming",
                outlineWidth = 6f,
                fontSize = 55.sp,
                color = SecondaryColorGames,
                outlineColor = PrimaryColorGames
            )
        }
    }
}