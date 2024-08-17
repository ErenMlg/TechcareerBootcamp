package com.softcross.techcareerhomework.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = NavyBlue,
    onSurface = White,
    secondary = BlackGray,
    tertiary = OrangeDark,
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    onSurface = Black,
    secondary = White,
    tertiary = OrangeDark,

)

@Composable
fun RamenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val view = LocalView.current
    if (!view.isInEditMode){
        SideEffect {
            val window = (view.context as Activity).window
            window.navigationBarColor = White.toArgb()
            window.statusBarColor = if (darkTheme) NavyBlue.toArgb() else Blue.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}