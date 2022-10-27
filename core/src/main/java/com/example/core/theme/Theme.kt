package com.example.core.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColor = darkColors(
    primary = Blue,
    primaryVariant = Blue,
    onPrimary = White,
    secondary = Red,
    secondaryVariant = Red,
    onSecondary = Black,

    background = BackgroundDark,
    onBackground = BackgroundDark,

    surface = CardDark,
    onSurface = CardDark
)

@SuppressLint("ConflictingOnColor")
private val LightColor = lightColors(
    primary = White,
    primaryVariant = Red,
    onPrimary = Black,

    secondary = Red,
    secondaryVariant = Red,
    onSecondary = Black,

    background = BackgroundLight,
    onBackground = BackgroundLight,

    surface = White,
    onSurface = White
)

val notesAppColors: Colors
    @Composable get() = MaterialTheme.colors

val notesAppShapes: Shapes
    @Composable get() = MaterialTheme.shapes

val notesAppTypography: Typography
    @Composable get() = MaterialTheme.typography

@Composable
fun NoteAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColor
    } else {
        LightColor
    }

    val typography = if (darkTheme) {
        DarkTypography
    } else {
        LightTypography
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}