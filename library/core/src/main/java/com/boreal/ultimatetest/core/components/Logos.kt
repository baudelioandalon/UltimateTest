package com.boreal.ultimatetest.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.boreal.ultimatetest.uisystem.R

@Composable
fun LogoSmall(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.boreal_logo
) {
    Image(
        modifier = modifier
            .width(75.dp)
            .fillMaxWidth(),
        painter = painterResource(id = icon), contentDescription = "icon"
    )
}