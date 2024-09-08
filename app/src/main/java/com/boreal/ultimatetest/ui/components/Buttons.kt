package com.boreal.ultimatetest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.ui.theme.PrimaryColor
import com.boreal.ultimatetest.ui.theme.SecondaryColor


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    borderRadius: Dp = 5.dp,
    fontSize: TextUnit = 15.sp,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        enabled = enabled,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryColor,
            contentColor = SecondaryColor
        ),
        shape = RoundedCornerShape(corner = CornerSize(borderRadius)),
        border = BorderStroke(2.dp, SecondaryColor),
        onClick = { onClick?.invoke() },
    ) {
        BoldText(
            text = text,
            fontSize = fontSize,
            color = Color.White,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center
        )
    }
}