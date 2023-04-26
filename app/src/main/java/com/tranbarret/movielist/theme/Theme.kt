package com.tranbarret.movielist.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = Black,
    secondary = Black
)

private val LightColorPalette = lightColorScheme(
    primary = Black,
    secondary = Black
)

@Composable
fun MovieTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
//        typography = Typography,
//        shapes = Shapes,
        content = content
    )
}