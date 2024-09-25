package com.example.skatelligenceapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC5),
    background = Color.Black, // Set the background to black
    surface = Color.Black,    // Set surfaces (e.g., cards, buttons) to black
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White, // Text color on background will be white
    onSurface = Color.White     // Text color on surfaces will be white
)

@Composable
fun SkatelligenceAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography, // Use your default or custom typography
        content = content
    )
}
