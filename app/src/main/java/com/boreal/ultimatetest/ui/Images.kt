package com.boreal.ultimatetest.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.boreal.ultimatetest.uisystem.R
import com.boreal.ultimatetest.ui.theme.BorderColor

@Composable
fun ImageFromUrl(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    rounded: Dp = 30.dp,
    image: String,
    contentScale: ContentScale = ContentScale.Crop
) {
    Card(
        modifier = modifier.size(size),
        shape = RoundedCornerShape(rounded),
        border = BorderStroke(1.dp, color = BorderColor)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .allowHardware(false)
                .build(),
            placeholder = painterResource(R.drawable.portal),
            contentDescription = stringResource(R.string.app_name),
            contentScale = contentScale
        )
    }
}