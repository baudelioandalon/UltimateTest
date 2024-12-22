package com.boreal.ultimatetest.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.core.domain.EMPTY_STRING


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun ResultLocationItem(
    modifier: Modifier = Modifier,
    primaryColor: Color = Black,
    secondaryColor: Color = Black,
    name: String = EMPTY_STRING,
    residents: List<String> = listOf("https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
    secondText: String = "habitantes",
    clicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        onClick = { clicked?.invoke() },
        elevation = 5.dp,
        shape = RectangleShape,
        border = BorderStroke(1.5.dp, color = secondaryColor),
        backgroundColor = White,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(start = 6.dp, bottom = 10.dp, end = 5.dp, top = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SemiBoldText(
                    text = name,
                    fontSize = 15.sp
                )
                SemiBoldText(
                    text = "${residents.size} $secondText",
                    fontSize = 12.sp,
                    color = primaryColor
                )
            }
            /**
             * Previsualizador de imagenes horizontales
             */
            HorizontalImageViewer(
                modifier = Modifier.padding(vertical = 15.dp),
                colorSelected = MaterialTheme.colors.primary,
                itemList = residents,
                zoomWhenSelected = true,
                itemClicked = { index, item ->

                }
            )
        }
    }
}