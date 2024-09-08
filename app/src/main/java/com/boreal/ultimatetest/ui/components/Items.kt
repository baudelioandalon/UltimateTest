package com.boreal.ultimatetest.ui.components

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
import com.boreal.ultimatetest.domain.model.CharacterModel
import com.boreal.ultimatetest.ui.ImageFromUrl
import com.boreal.ultimatetest.ui.theme.GrayBackgroundDrawerDismiss
import com.boreal.ultimatetest.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun ResultItem(
    modifier: Modifier = Modifier,
    model: CharacterModel = CharacterModel(
        id = 1,
        name = "Rick",
        status = "Alive",
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
    ),
    clicked: (() -> Unit)? = null,
    statusColor: Color = Black
) {
    runCatching {
        Card(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            onClick = { clicked?.invoke() },
            elevation = 5.dp,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.5.dp, color = SecondaryColor),
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
                            color = GrayBackgroundDrawerDismiss,
                            shape = RoundedCornerShape(topEnd = 0.dp, topStart = 0.dp)
                        )
                        .requiredHeight(200.dp)
                        .fillMaxWidth()
                ) {
                    ImageFromUrl(
                        modifier = Modifier.fillMaxSize(),
                        image = model.image,
                        shape = RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp,
                            bottomEnd = 30.dp,
                            bottomStart = 30.dp
                        ),
                        contentScale = ContentScale.Crop
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
                        text = model.name,
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
                            text = model.status,
                            textAlign = TextAlign.Start,
                            textOverflow = TextOverflow.Ellipsis,
                            fontSize = 10.sp,
                            maxLines = 1
                        )
                        Box(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .requiredSize(10.dp)
                                .background(color = statusColor, shape = CircleShape)
                        )
                    }
                }
            }
        }
    }

}