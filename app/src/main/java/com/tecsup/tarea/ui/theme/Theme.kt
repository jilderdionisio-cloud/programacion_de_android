package com.tecsup.tarea.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = OceanBlue,
    secondary = MintTech,
    tertiary = AzureSoft,
    background = Color(0xFF0A1020)
)

private val LightColorScheme = lightColorScheme(
    primary = OceanBlue,
    secondary = MintTech,
    tertiary = AzureSoft,
    background = SpaceBackground,
    surface = Color.White,
    onPrimary = Color.White,
    onSurface = DeepNavy
)

@Composable
fun TareaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
