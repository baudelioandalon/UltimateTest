package com.boreal.ultimatetest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.boreal.ultimatetest.core.ui.theme.DEFAULT_TYPOGRAPHY
import com.boreal.ultimatetest.core.ui.theme.PrimaryColor
import com.boreal.ultimatetest.core.ui.theme.PrimaryEndColor
import com.boreal.ultimatetest.core.ui.theme.SecondaryColor
import com.boreal.ultimatetest.core.ui.theme.TypographyEmbedded
import com.boreal.ultimatetest.core.ui.theme.font
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_background
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_error
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_onBackground
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_onError
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_onPrimary
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_onSecondary
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_onSurface
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_primary
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_secondary
import com.boreal.ultimatetest.core.ui.theme.md_theme_dark_surface
import com.boreal.ultimatetest.core.ui.theme.md_theme_light_background
import com.boreal.ultimatetest.core.ui.theme.md_theme_light_error
import com.boreal.ultimatetest.core.ui.theme.md_theme_light_onBackground
import com.boreal.ultimatetest.core.ui.theme.md_theme_light_onError
import com.boreal.ultimatetest.core.ui.theme.md_theme_light_onSecondary
import com.boreal.ultimatetest.core.ui.theme.md_theme_light_onSurface
import com.boreal.ultimatetest.core.ui.theme.md_theme_light_surface
import com.boreal.ultimatetest.uisystem.R


private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = PrimaryEndColor,
    secondary = SecondaryColor,
    onSecondary = md_theme_light_onSecondary,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp),
)


@Composable
fun thinTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            R.font.montserrat_thin,
            Thin,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", R.font.roboto_thin, Thin, FontStyle.Normal
            )
        }
    }
)


@Composable
fun UltimateTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) DarkColorScheme else LightColorScheme
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    SystemAppearance(darkTheme)
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


@Composable
fun SystemAppearance(isDark: Boolean) {
    val view = LocalView.current
    val systemBarColor = android.graphics.Color.TRANSPARENT
    LaunchedEffect(isDark) {
        val window = (view.context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = systemBarColor
        window.navigationBarColor = systemBarColor//Esto es para el bottomNavigation
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = isDark
            isAppearanceLightNavigationBars = isDark
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}

