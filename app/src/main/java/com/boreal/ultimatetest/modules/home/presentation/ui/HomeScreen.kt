package com.boreal.ultimatetest.modules.home.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boreal.ultimatetest.modules.home.components.ToolbarTitle

@Composable
fun HomeScreen() {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolbarTitle(
                titleText = "Home",
                showStartImage = false,
                helpButtonClicked = {

                },
                helpButton = true
            )
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .wrapContentHeight()
                .padding(top = 23.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}