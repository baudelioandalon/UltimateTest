package com.boreal.ultimatetest.games.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.core.components.ImageFromUrl
import com.boreal.ultimatetest.core.components.SemiBoldText
import com.boreal.ultimatetest.core.ui.theme.BorderColor
import com.boreal.ultimatetest.core.ui.theme.GrayBackgroundDrawerDismiss
import com.boreal.ultimatetest.core.ui.theme.SecondaryColor
import com.boreal.ultimatetest.games.domain.model.GamesResponseModelItem

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun ResultGameItem(
    modifier: Modifier = Modifier,
    secondaryColor: Color = SecondaryColor,
    backgroundColor: Color = GrayBackgroundDrawerDismiss,
    borderColor: Color = BorderColor,
    model: GamesResponseModelItem = GamesResponseModelItem(
        id = 1,
        title = "Overwatch 2",
        short_description = "A hero-focused first-person team shooter from Blizzard Entertainment.",
        thumbnail = "https://www.freetogame.com/g/540/thumbnail.jpg",
        game_url = "https://www.freetogame.com/open/overwatch-2",
        genre = "Shooter",
        platform = "PC (Windows)",
        publisher = "Activision Blizzard",
        developer = "Blizzard Entertainment",
        release_date = "2022-10-04",
    ),
    clicked: (() -> Unit)? = null
) {
    runCatching {
        Card(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            onClick = { clicked?.invoke() },
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.5.dp, color = secondaryColor),
            backgroundColor = White,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = backgroundColor,
                            shape = RoundedCornerShape(topEnd = 0.dp, topStart = 0.dp)
                        )
                        .requiredHeight(200.dp)
                        .fillMaxWidth()
                ) {
                    ImageFromUrl(
                        modifier = Modifier.fillMaxSize(),
                        image = model.thumbnail.orEmpty(),
                        shape = RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp,
                            bottomEnd = 30.dp,
                            bottomStart = 30.dp
                        ),
                        contentScale = ContentScale.Crop,
                        borderColor = borderColor
                    )
                }

                //Info
                Row(
                    modifier = Modifier
                        .padding(start = 6.dp, bottom = 5.dp, end = 5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Name
                    SemiBoldText(
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(0.5f),
                        text = model.title.orEmpty(),
                        textAlign = TextAlign.Start,
                        textOverflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp,
                        maxLines = 1
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SemiBoldText(
                            modifier = Modifier
                                .padding(top = 5.dp),
                            text = model.genre.orEmpty(),
                            textAlign = TextAlign.Start,
                            textOverflow = TextOverflow.Ellipsis,
                            fontSize = 10.sp,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }

}