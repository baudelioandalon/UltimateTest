package com.boreal.ultimatetest.modules.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.boreal.ultimatetest.uisystem.R as uiR


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CircularIcon(
    modifier: Modifier = Modifier,
    icon: Int = uiR.drawable.ic_back_arrow,
    contentDescription: String? = null,
    iconTint: Color = Color.White,
    backgroundColor: Color = MaterialTheme.colors.primary,
    sizeContent: Dp = 62.dp,
    sizeIcon: Dp = 45.dp,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .size(sizeContent),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .size(sizeIcon),
            backgroundColor = backgroundColor,
            elevation = 0.dp,
            shape = CircleShape, onClick = { onClick?.invoke() }) {
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(5.dp),
                painter = painterResource(id = icon),
                tint = iconTint,
                contentDescription = contentDescription
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CircularImage(
    modifier: Modifier = Modifier,
    icon: Int = uiR.drawable.ic_back_arrow,
    iconTint: ColorFilter? = null,
    size: Dp = 45.dp,
    backgroundColor: Color = MaterialTheme.colors.primary,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .size(62.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .size(size),
            elevation = 0.dp,
            backgroundColor = backgroundColor,
            shape = CircleShape, onClick = { onClick?.invoke() }) {
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(5.dp),
                painter = painterResource(id = icon),
                contentDescription = "",
                colorFilter = iconTint
            )
        }
    }
}