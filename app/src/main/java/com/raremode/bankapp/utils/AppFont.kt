package com.raremode.bankapp.utils

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.raremode.bankapp.R

object AppFont {
    val Girloy = FontFamily(
        Font(R.font.girloy_thin, FontWeight.Thin),
        Font(R.font.girloy_light, FontWeight.Light),
        Font(R.font.girloy_regular, FontWeight.Normal),
        Font(R.font.girloy_medium, FontWeight.Medium),
        Font(R.font.girloy_semibold, FontWeight.SemiBold),
        Font(R.font.girloy_extrabold, FontWeight.ExtraBold)
        )
}

private val defaultTypography = Typography()
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.Girloy),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.Girloy),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.Girloy),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.Girloy),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.Girloy),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.Girloy),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.Girloy),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.Girloy),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.Girloy),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.Girloy),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.Girloy),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.Girloy),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.Girloy),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.Girloy),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.Girloy)
)