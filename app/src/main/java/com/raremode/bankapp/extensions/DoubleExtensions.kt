package com.raremode.bankapp.extensions

import java.util.Currency
import java.util.Locale
import kotlin.math.abs

fun Double.format(digits: Int) = String.Companion.format(
    java.util.Locale.getDefault(),
    "%..${digits}f",
    this
)

fun Double.addNumbersAfterComma(): String {
    val numberAsString = this.toString()
    val nofDecimals = numberAsString.substringAfter('.', "").length
    return String.format("%,.${nofDecimals}f", numberAsString.toDouble())
}

fun Double.toCurrencyString(): String {
    return String.format(
        if (this > 0) {
            "+"
        } else {
            ""
        } + "${Currency.getInstance(Locale.getDefault()).symbol}%.2f",
        this
    ).replace(".", ",")
}

fun Double.toTransactionHistoryItemSum(): String {
    return String.format(
        (if (this > 0) "+" else "-") + "${Currency.getInstance(Locale.getDefault()).symbol}%.2f",
        abs(this)
    ).replace(".", ",")
//
//    val formattedTransactionSum = if (this > 0) "+$sum"
//    else "-$sum"
}