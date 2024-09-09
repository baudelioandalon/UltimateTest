package com.boreal.ultimatetest.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.boreal.ultimatetest.modules.main.presentation.ui.MainViewCompose
import com.boreal.ultimatetest.ui.theme.UltimateTestTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UltimateTestTheme {
                MainViewCompose()
            }
        }
    }
}