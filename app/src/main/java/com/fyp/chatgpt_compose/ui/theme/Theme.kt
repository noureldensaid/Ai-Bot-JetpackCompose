package com.fyp.chatgpt_compose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = Purple80,
    secondary = Purple80,
    onSecondary = Color.DarkGray,
    background = BackGroundColor,
    surface = PrimaryColor,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Purple40,
    secondary = Purple40,
    onSurface = Color.White,
    onSecondary = Color.DarkGray,
    background = BackGroundMessageHuman,
    surface = BackGroundColor,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ChatGptComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = BackGroundColor,
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = BackGroundMessageHuman
        )
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}