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