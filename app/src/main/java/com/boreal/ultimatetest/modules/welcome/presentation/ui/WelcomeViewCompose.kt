package com.boreal.ultimatetest.modules.welcome.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.boreal.ultimatetest.domain.NavigationScreen
import com.boreal.ultimatetest.ui.components.BoldText
import com.boreal.ultimatetest.ui.components.LogoBlue
import com.boreal.ultimatetest.ui.components.OutlinedText
import com.boreal.ultimatetest.ui.components.PrimaryButton
import com.boreal.ultimatetest.ui.theme.PrimaryColor
import com.boreal.ultimatetest.ui.theme.SecondaryColor
import com.boreal.ultimatetest.ui.theme.mediumTypo
import com.boreal.ultimatetest.uisystem.R

@Preview(showBackground = true)
@Composable
fun WelcomeViewCompose(navController: NavController? = null) {

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
            painter = painterResource(id = R.drawable.rick_and_morty_siluet),
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.padding(top = 7.dp),
                    painter = painterResource(
                        id = R.drawable.rick_and_morty_name
                    ), contentDescription = "icon"
                )
                OutlinedText(
                    modifier = Modifier.padding(start = 16.dp, bottom =30.dp),
                    text = "App",
                    outlineWidth = 10f,
                    fontSize = 135.sp
                )

            }

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
                        "En la siguiente pantalla se comenzará a usar las\n" +
                                "peticiones al servidor "
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
                    append("RickAndMortyApi.com")
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
                text = "Entrar"
            ) {
                navController?.navigate(NavigationScreen.HomeScreen.route)
            }

            LogoBlue(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 10.dp)
                    .width(75.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )

            OutlinedText(
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(end = 160.dp),
                text = "Wubba lubba dub dub",
                outlineWidth = 6f,
                fontSize = 55.sp
            )
        }
    }
}