package com.boreal.ultimatetest.modules.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.core.domain.EMPTY_STRING
import com.boreal.ultimatetest.uisystem.R

@Preview(showBackground = true)
@Composable
fun ToolbarTitle(
    modifier: Modifier = Modifier,
    titleText: String = "",
    showStartImage: Boolean = true,
    startClicked: (() -> Unit)? = null,
    endClicked: (() -> Unit)? = null,
    showEndImage: Boolean = false,
    helpButtonClicked: (() -> Unit)? = null,
    helpButton: Boolean = false,
    startIcon: Int = R.drawable.ic_back_arrow,
    startIconTint: Color = White,
    endIconTint: Color = White,
    endIcon: Int = R.drawable.ic_back_arrow,
    backgroundColor: Color = MaterialTheme.colors.primary
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(backgroundColor)
    ) {
        if (showStartImage) {
            CircularIcon(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterStart),
                backgroundColor = backgroundColor,
                iconTint = startIconTint,
                icon = startIcon
            ) {
                startClicked?.invoke()
            }
        }
        RegularText(
            modifier = Modifier.align(Alignment.Center),
            text = titleText,
            textAlign = TextAlign.Justify,
            fontSize = 20.sp,
            color = White
        )
        if (showEndImage) {
            CircularIcon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 5.dp),
                backgroundColor = backgroundColor,
                iconTint = endIconTint,
                icon = endIcon
            ) {
                endClicked?.invoke()
            }
        }
        if (helpButton) {
            Surface(
                modifier = Modifier.align(Alignment.CenterEnd),
                color = MaterialTheme.colors.primary
            ) {
                CircularImage(
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(),
                    size = 100.dp,
                    icon = R.drawable.ic_help_icon
                ) {
                    helpButtonClicked?.invoke()
                }
            }
        }
    }

}

@Preview
@Composable
fun ToolbarMain(
    modifier: Modifier = Modifier,
    showOptionsButton: Boolean = true,
    showSalesButton: Boolean = true,
    showBlockButton: Boolean = true,
    showHelpButton: Boolean = true,
    optionsButtonClicked: (() -> Unit)? = null,
    salesButtonClicked: (() -> Unit)? = null,
    blockButtonClicked: (() -> Unit)? = null,
    helpButtonClicked: (() -> Unit)? = null,
    endClicked: (() -> Unit)? = null,
    startIcon: Int = R.drawable.ic_back_arrow,
    centerIcon: Int = R.drawable.ic_back_arrow,
    endIconTint: Color? = White,
    endIcon: Int = R.drawable.ic_back_arrow
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showOptionsButton) {
            //Flecha
//            Image(
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxHeight()
//                    .background(MaterialTheme.colors.primary)
//                    .clickable {
//                        startClicked?.invoke()
//                    },
//                painter = painterResource(id = startIcon),
//                contentDescription = ""
//            )
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        if (!showOptionsButton) return@clickable
                        optionsButtonClicked?.invoke()
                    },
                color = MaterialTheme.colors.primary
            ) {
                BoldText(
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    text = if (showOptionsButton) "OPCIONES" else EMPTY_STRING,
                    color = White
                )
            }
        } else {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.primary)
            )
        }

        Surface(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    if (!showSalesButton) return@clickable
                    salesButtonClicked?.invoke()
                },
            color = MaterialTheme.colors.primary
        ) {
            BoldText(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                text = if (showSalesButton) "VENTAS" else EMPTY_STRING,
                color = White
            )
        }
        Image(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colors.primary)
                .clickable {
//                    startClicked?.invoke()
                },
            painter = painterResource(id = centerIcon),
            contentDescription = ""
        )

        Surface(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    if (!showBlockButton) return@clickable
                    blockButtonClicked?.invoke()
                },
            color = MaterialTheme.colors.primary
        ) {
            BoldText(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                text = if (showBlockButton) "BLOQUEAR" else EMPTY_STRING,
                color = White
            )
        }
        Surface(
            modifier = Modifier
                .weight(1f),
            color = MaterialTheme.colors.primary
        ) {
            CircularImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(),
                size = 100.dp,
                icon = R.drawable.ic_help_icon
            ) {
                if (!showHelpButton) return@CircularImage
                helpButtonClicked?.invoke()
            }
        }
    }


}