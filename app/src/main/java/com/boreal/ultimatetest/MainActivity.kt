package com.boreal.ultimatetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.boreal.ultimatetest.modules.home.presentation.ui.HomeScreen
import com.boreal.ultimatetest.modules.welcome.presentation.ui.WelcomeViewCompose
import com.boreal.ultimatetest.ui.theme.UltimateTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UltimateTestTheme {
                WelcomeViewCompose()
            }
        }
    }
}