package com.boreal.ultimatetest.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import com.boreal.ultimatetest.uisystem.R

enum class TypographyEmbedded() {
    ROBOTO, MONTSERRAT
}

val DEFAULT_TYPOGRAPHY = TypographyEmbedded.MONTSERRAT

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


@Composable
fun font(name: String, res: Int, weight: FontWeight, style: FontStyle): Font {
    return Font(res, weight, style)
}