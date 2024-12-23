package com.boreal.ultimatetest.games.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.boreal.ultimatetest.core.components.CircularIcon
import com.boreal.ultimatetest.core.domain.EMPTY_STRING

//
@Composable
fun ToolbarSearch(
    modifier: Modifier = Modifier,
    primaryColor: Color = MaterialTheme.colors.primary,
    backClicked: (() -> Unit)? = null,
    searchedText: ((String) -> Unit)? = null,
    showClose: Boolean = false,
    closeClicked: (() -> Unit)? = null
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by rememberSaveable { mutableStateOf("") }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RectangleShape,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(MaterialTheme.colors.primary)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (backClicked != null) {
                    CircularIcon(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(35.dp),
                        iconTint = White,
                    ) {
                        backClicked.invoke()
                    }
                }

                SearcherWithButton(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    value = searchText,
                    placeHolder = "Buscar",
                    showClose = showClose,
                    primaryColor = primaryColor,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    onValueChange = {
                        searchText = it
                        searchedText?.invoke(it)
                    },
                    settingsClicked = {
                        searchText = EMPTY_STRING
                        closeClicked?.invoke()
                    }
                )

            }


        }
    }
}