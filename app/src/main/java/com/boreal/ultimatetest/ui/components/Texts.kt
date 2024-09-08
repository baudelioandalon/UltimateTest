package com.boreal.ultimatetest.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.ui.theme.GrayLetterSeeAll
import com.boreal.ultimatetest.ui.theme.PrimaryColor
import com.boreal.ultimatetest.ui.theme.SecondaryColor
import com.boreal.ultimatetest.ui.theme.boldTypo
import com.boreal.ultimatetest.ui.theme.lightTypo
import com.boreal.ultimatetest.ui.theme.mediumTypo
import com.boreal.ultimatetest.ui.theme.regularTypo
import com.boreal.ultimatetest.ui.theme.semiBoldTypo


@Composable
fun SemiBoldText(
    modifier: Modifier = Modifier,
    text: String,
    letterSpacing: TextUnit = 0.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    fontSize: TextUnit = 18.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        letterSpacing = letterSpacing,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = semiBoldTypo()
    )
}

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String,
    letterSpacing: TextUnit = 0.sp,
    fontSize: TextUnit = 25.sp,
    color: Color = Color.White,
    textAlign: TextAlign? = null,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    onClicked: (() -> Unit)? = null
) {
    Text(
        modifier = if (onClicked != null) modifier.clickable { onClicked.invoke() } else modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        letterSpacing = letterSpacing,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = boldTypo()
    )
}

@Composable
fun MediumText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    letterSpacing: TextUnit = 0.sp,
    fontSize: TextUnit = 20.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        letterSpacing = letterSpacing,
        color = color,
        fontWeight = Medium,
        textAlign = textAlign,
        overflow = textOverflow,
        maxLines = maxLines,
        fontFamily = mediumTypo()
    )
}


@Composable
fun MediumTextBold(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 20.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = Bold,
        textAlign = textAlign,
        fontFamily = mediumTypo()
    )
}


@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 15.sp,
    color: Color = Color.Black,
    letterSpacing: TextUnit = 0.sp,
    maxLines: Int = Int.MAX_VALUE,
    lineHeight: TextUnit = 14.sp,
    textOverflow: TextOverflow = TextOverflow.Clip,
    style: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = fontSize,
        color = color,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        fontWeight = Normal,
        maxLines = maxLines,
        overflow = textOverflow,
        textAlign = textAlign,
        style = style,
        fontFamily = regularTypo()
    )
}

@Composable
fun LightText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 15.sp,
    color: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = fontSize,
        color = color,
        fontWeight = Normal,
        textAlign = textAlign,
        fontFamily = lightTypo()
    )
}

@Composable
fun SmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = GrayLetterSeeAll,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,// ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 12.sp,
        color = color,
        letterSpacing = 0.sp,
        fontWeight = Bold,
        textAlign = textAlign,
        fontFamily = regularTypo()
    )
}


@Composable
fun OutlinedText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = PrimaryColor,
    outlineColor: Color = SecondaryColor,
    outlineWidth: Float = 4f,
    fontSize: TextUnit = 15.sp
) {
    Box(modifier = modifier) {
        Canvas(modifier = Modifier) {
            val paint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                textSize = fontSize.value
                style = android.graphics.Paint.Style.STROKE
                strokeWidth = outlineWidth
                this.color = outlineColor.toArgb()
            }

            drawContext.canvas.nativeCanvas.drawText(
                text,
                0f,
                fontSize.value,
                paint
            )

            paint.style = android.graphics.Paint.Style.FILL
            paint.color = color.toArgb()

            drawContext.canvas.nativeCanvas.drawText(
                text,
                0f,
                fontSize.value,
                paint
            )
        }
    }

}