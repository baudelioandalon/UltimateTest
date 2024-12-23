package com.boreal.ultimatetest.games.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.ultimatetest.core.components.BoldText
import com.boreal.ultimatetest.core.components.CircularIcon
import com.boreal.ultimatetest.core.components.SemiBoldText
import com.boreal.ultimatetest.core.ui.theme.GrayBackgroundSearch
import com.boreal.ultimatetest.core.ui.theme.GrayBorderSearch
import com.boreal.ultimatetest.core.ui.theme.GrayLetterHint
import com.boreal.ultimatetest.core.ui.theme.PrimaryColor
import com.boreal.ultimatetest.core.utils.mirror
import com.boreal.ultimatetest.uisystem.R


@Preview(showBackground = true)
@Composable
fun TestSearchs() {
    Column(
        Modifier
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        SearchOutlinedTextField(
            value = "",
            placeHolder = "Buscar",
            onValueChange = {}
        )

        SearcherWithButton(
            value = "",
            placeHolder = "Buscar",
            onValueChange = {}
        )
    }
}


@Composable
fun SearcherWithSettings(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        keyboardType = KeyboardType.Text
    ),
    keyboardActions: KeyboardActions = KeyboardActions { },
    enabled: Boolean = true,
    singleLine: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = GrayBackgroundSearch,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent, textColor = GrayLetterHint,
        disabledTextColor = GrayLetterHint,
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onDone: ((String) -> Unit)? = null,
    settingsClicked: (() -> Unit)? = null,
    itemClicked: (() -> Unit)? = null,
    showSettings: Boolean = false,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        val interactionSource = remember { MutableInteractionSource() }
        Row(
            modifier = Modifier.background(
                color = GrayBackgroundSearch,
                shape = RoundedCornerShape(corner = CornerSize(10.dp))
            )
                .weight(1f)
                .clickable { itemClicked?.invoke() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.8f)
                    .height(52.dp),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                textStyle = TextStyle(
                    color = Black,
                    fontWeight = SemiBold,
                    fontSize = 15.sp
                ),
                interactionSource = interactionSource,
                value = value,
                onValueChange = {
                    onValueChange(it)
                }, placeholder = {
                    SemiBoldText(
                        text = placeHolder,
                        color = GrayLetterHint,
                        fontSize = 16.sp
                    )
                },
                colors = colors,
                isError = false,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                enabled = enabled,
                singleLine = singleLine,
                visualTransformation = visualTransformation
            )
            if (value.isNotEmpty()) {
                CircularIcon(
                    modifier = Modifier
                        .mirror()
                        .padding(10.dp)
                        .size(35.dp),
                    iconTint = PrimaryColor,
                    backgroundColor = GrayBackgroundSearch,
                ) {
                    onDone?.invoke(value)
                }
            }
        }

        if (showSettings){
            CircularIcon(
                modifier = Modifier.padding(start = 10.dp)
                    .size(35.dp),
                icon = R.drawable.ic_settings_gray,
                onClick = {
                    settingsClicked?.invoke()
                }
            )
        }


    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchOutlinedTextField(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    onValueChange: (String) -> Unit,
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        keyboardType = KeyboardType.Text
    ),
    keyboardActions: KeyboardActions = KeyboardActions { },
    enabled: Boolean = false,
    singleLine: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = GrayBackgroundSearch,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent, textColor = GrayLetterHint,
        disabledTextColor = GrayLetterHint,
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    settingsClicked: (() -> Unit)? = null,
    itemClicked: (() -> Unit)? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth(0.6f)
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                    color = GrayBorderSearch
                )
                .clickable(
//                    interactionSource = MutableInteractionSource(),
//                    indication = ripple(
//                        bounded = true,
//                        color = GrayLetterHint.copy(alpha = 0.1f)
//                    )
                ) { itemClicked?.invoke() },
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            textStyle = TextStyle(
                color = Black,
                fontWeight = SemiBold,
                fontSize = 15.sp
            ),
            interactionSource = interactionSource,
            value = value,
            onValueChange = {
                onValueChange(it)
            }, placeholder = {
                Text(
                    text = placeHolder,
                    color = GrayLetterHint,
                    fontWeight = SemiBold,
                    fontSize = 16.sp
                )
            },
            colors = colors,
            isError = false,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            leadingIcon = {
                Card(
                    modifier = Modifier
                        .size(35.dp),
                    elevation = 0.dp,
                    shape = CircleShape, backgroundColor = GrayBackgroundSearch
                ) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_search_icon),
                        contentDescription = "settingsIcon"
                    )
                }
            },
            trailingIcon = {
                Card(
                    modifier = Modifier
                        .size(35.dp),
                    elevation = 0.dp,
                    shape = CircleShape,
                    backgroundColor = GrayBackgroundSearch,
                    onClick = { settingsClicked?.invoke() }) {
                    Icon(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_settings_gray),
                        contentDescription = "settingsIcon"
                    )
                }
            },
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = visualTransformation
        )

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearcherWithButton(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    onValueChange: (String) -> Unit,
    value: String,
    primaryColor: Color?=null,
    withButtonSearch: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        keyboardType = KeyboardType.Text
    ),
    keyboardActions: KeyboardActions = KeyboardActions { },
    enabled: Boolean = true,
    singleLine: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = GrayBackgroundSearch,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent, textColor = GrayLetterHint,
        disabledTextColor = GrayLetterHint,
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    settingsClicked: (() -> Unit)? = null,
    itemClicked: (() -> Unit)? = null
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        val interactionSource = remember { MutableInteractionSource() }
        Column(modifier = Modifier.weight(1f)) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                textStyle = TextStyle(
                    color = Black,
                    fontWeight = SemiBold,
                    fontSize = 15.sp
                ),
                interactionSource = interactionSource,
                value = value,
                onValueChange = { onValueChange(it) }, placeholder = {
                    Text(
                        text = placeHolder,
                        color = GrayLetterHint,
                        fontWeight = SemiBold,
                        fontSize = 16.sp
                    )
                },
                colors = colors,
                isError = false,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                leadingIcon = {
                    Card(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp),
                        elevation = 0.dp,
                        shape = CircleShape, backgroundColor = GrayBackgroundSearch
                    ) {
                        Icon(
                            modifier = Modifier.wrapContentSize(),
                            tint = primaryColor ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                            painter = painterResource(id = R.drawable.ic_search_icon),
                            contentDescription = "settingsIcon"
                        )
                    }
                },
                trailingIcon = {
                    if(settingsClicked!= null){
                        Card(
                            modifier = Modifier
                                .width(35.dp)
                                .height(35.dp),
                            elevation = 0.dp,
                            shape = CircleShape,
                            backgroundColor = GrayBackgroundSearch,
                            onClick = { settingsClicked?.invoke() }) {
                            Icon(
                                modifier = Modifier.wrapContentSize(),
                                painter = painterResource(id = R.drawable.ic_settings_gray),
                                contentDescription = "settingsIcon",
                                tint = Black
                            )
                        }
                    }
                },
                enabled = enabled,
                singleLine = singleLine,
                visualTransformation = visualTransformation
            )

        }
        if (withButtonSearch) {
            BoldText(
                modifier = Modifier
                    .padding(start = 33.dp)
                    .clickable { itemClicked?.invoke() },
                text = "Buscar", fontSize = 14.sp,
                color = MaterialTheme.colors.primary
            )
        }
    }
}