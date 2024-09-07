package com.boreal.ultimatetest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.boreal.ultimatetest.uisystem.R


private enum class TypographyEmbedded() {
    ROBOTO, MONTSERRAT
}

private val DEFAULT_TYPOGRAPHY = TypographyEmbedded.ROBOTO

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = PrimaryEndColor,
    secondary = md_theme_light_secondary,
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
fun lightTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            R.font.roboto_light,
            Light,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", R.font.roboto_light, Light, FontStyle.Normal
            )
        }
    }
)

@Composable
fun regularTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            R.font.montserrat_regular,
            Normal,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", R.font.roboto, Normal, FontStyle.Normal
            )
        }
    }
)

@Composable
fun robotoMediumTypo() = FontFamily(
    font(
        "Roboto", R.font.roboto, Normal, FontStyle.Normal
    )
)

@Composable
fun mediumTypo() =
    FontFamily(
        when (DEFAULT_TYPOGRAPHY) {
            TypographyEmbedded.MONTSERRAT -> font(
                "Montserrat",
                R.font.montserrat_medium,
                Medium,
                FontStyle.Normal
            )

            else -> {

                font(
                    "Roboto", R.font.roboto, Medium, FontStyle.Normal
                )
            }
        }
    )

@Composable
fun semiBoldTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            R.font.montserrat_semibold,
            Normal,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", R.font.roboto, SemiBold, FontStyle.Normal
            )
        }
    }
)

@Composable
fun boldTypo() =
    FontFamily(
        when (DEFAULT_TYPOGRAPHY) {
            TypographyEmbedded.MONTSERRAT -> font(
                "Montserrat",
                R.font.montserrat_bold,
                Bold,
                FontStyle.Normal
            )

            else -> {

                font(
                    "Roboto", R.font.roboto_bold, Bold, FontStyle.Normal
                )
            }
        }
    )


internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(false) }



@Composable
fun UltimateTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
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
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = systemBarColor
//        window.navigationBarColor = systemBarColor//Esto es para el bottomNavigation
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = isDark
            isAppearanceLightNavigationBars = isDark
        }
    }
}

@Composable
fun font(name: String, res: Int, weight: FontWeight, style: FontStyle): Font {
    return Font(res, weight, style)
}