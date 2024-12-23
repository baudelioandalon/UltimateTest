package com.boreal.ultimatetest.games.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.core.components.BoldText
import com.boreal.ultimatetest.core.components.SemiBoldText
import com.boreal.ultimatetest.core.ui.theme.CategoryBackgroundSelectorOne

@Composable
fun CategorySelectorItem(
    modifier: Modifier = Modifier,
    category: String = "",
    size: Dp = 50.dp,
    color: Color = CategoryBackgroundSelectorOne,
    categorySelected: (String) -> Unit = {}
) {
    Column(
        modifier = modifier.clickable {
            categorySelected(category)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(color, shape = RoundedCornerShape(15.dp))
        ) {

            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                BoldText(
                    modifier = Modifier.fillMaxWidth(),
                    text = category.first().uppercase(),
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    color = White
                )
            }

        }

        SemiBoldText(
            modifier = Modifier.padding(top = 8.dp),
            text = category,
            textAlign = TextAlign.Center,
            color = Black,
            fontSize = 12.sp
        )
    }


}