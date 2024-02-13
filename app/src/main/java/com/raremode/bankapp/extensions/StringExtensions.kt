package com.raremode.bankapp.extensions

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.LocaleList
import androidx.core.net.toUri

fun String.retrieveServiceName(): String {
    return this.toUri().authority
        .toString()
        .dropLastWhile { it != '.' }
        .removeSuffix(".")
        .capitalize(localeList = LocaleList())
}

fun String.dropSignsFromSum(): String {
    return this.replace("+", "")
}