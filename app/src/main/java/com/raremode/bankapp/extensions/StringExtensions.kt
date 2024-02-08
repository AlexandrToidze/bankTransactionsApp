package com.raremode.bankapp.extensions

import androidx.core.net.toUri
import java.util.Currency
import java.util.Locale

fun String.retrieveServiceName() : String {
    return this.toUri().authority.toString()
        .dropLastWhile { it != '.' }
}