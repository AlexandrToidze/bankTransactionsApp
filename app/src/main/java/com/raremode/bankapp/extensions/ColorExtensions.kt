package com.raremode.bankapp.extensions

import androidx.compose.ui.graphics.Color

fun Double.isPositiveSum(): Color {
    return if (this > 0) Color.Green
    else Color.White
}