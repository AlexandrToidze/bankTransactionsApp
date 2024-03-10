package com.aiweapps.bbank.extensions

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.LocaleList
import androidx.core.net.toUri
import kotlin.math.abs

fun String.retrieveServiceName(): String {
    return this
        .toUri().authority.toString()
        .dropLastWhile { it != '.' }
        .removeSuffix(".")
        .capitalize(localeList = LocaleList())
}

fun String.dropSignsFromSum(): String {
    return this.replace("+", "")
}

fun Double.toCashbackBoxForm(): String {
    val checkIfNearToTen = abs(this).toInt() % 10
    val howMuchDigitsAfterComma = if (checkIfNearToTen == 0) "+%.1f" else "+%.2f"
    return String
        .format(howMuchDigitsAfterComma, abs(this) * 0.01)
        .replace(".", ",")
}