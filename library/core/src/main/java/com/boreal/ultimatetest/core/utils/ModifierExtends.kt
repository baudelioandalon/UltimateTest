package com.boreal.ultimatetest.core.utils

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

@Stable
fun Modifier.mirror(): Modifier {
    return scale(scaleX = -1f, scaleY = 1f)
}