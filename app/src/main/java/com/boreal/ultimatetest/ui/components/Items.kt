package com.boreal.ultimatetest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.domain.model.CharacterModel
import com.boreal.ultimatetest.ui.ImageFromUrl
import com.boreal.ultimatetest.ui.theme.GrayBackgroundDrawerDismiss

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ResultItem(
    modifier: Modifier = Modifier,
    model: CharacterModel,
    clicked: (() -> Unit)? = null
) {
    runCatching {
        Card(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            onClick = { clicked?.invoke() },
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp),
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
                            shape = RoundedCornerShape(10.dp)
                        )
                        .requiredHeight(200.dp)
                        .fillMaxWidth()
                ) {
                    ImageFromUrl(
                        modifier = Modifier.fillMaxSize(),
                        image = model.image,
                        contentScale = ContentScale.Crop
                    )
                }

                //Name
                RegularText(
                    modifier = Modifier
                        .padding(start = 6.dp, top = 5.dp)
                        .fillMaxWidth(),
                    text = model.name,
                    textAlign = TextAlign.Start,
                    textOverflow = TextOverflow.Ellipsis,
                    fontSize = 10.sp,
                    maxLines = 2
                )


                //Info
                Row(
                    modifier = Modifier
                        .padding(start = 6.dp, bottom = 5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RegularText(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(end = 5.dp),
                        text = model.status,
                        color = Black
                    )
                }
            }
        }
    }

}