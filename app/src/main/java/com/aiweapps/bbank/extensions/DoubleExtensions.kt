package com.aiweapps.bbank.extensions

import java.util.Currency
import java.util.Locale
import kotlin.math.abs

fun Double.toTransactionHistoryItemSum(): String {
    return String.format(
        (if (this > 0) "+" else "-") + "${Currency.getInstance(Locale.getDefault()).symbol}%.2f",
        abs(this)
    ).replace(".", ",")
}

fun Double.toTransactionCashbackForm(withCurrency: Boolean, withSign: Boolean): String {
    val checkIfNearToTen = abs(this).toInt() % 10
    var howMuchDigitsAfterComma = if (checkIfNearToTen == 0) "%.1f" else "%.2f"

    if (withSign) howMuchDigitsAfterComma = "+$howMuchDigitsAfterComma"

    return String.format(
        if (withCurrency) "${Currency.getInstance(Locale.getDefault()).symbol}" + howMuchDigitsAfterComma
        else howMuchDigitsAfterComma,
        abs(this) * 0.01
    )
}