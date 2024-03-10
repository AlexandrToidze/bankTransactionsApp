package com.aiweapps.bbank.models

import android.content.Context
import androidx.annotation.DrawableRes
import com.aiweapps.bbank.R

data class TransactionHistoryModel(
    @DrawableRes val icon: Int = R.drawable.ic_search,
    val service: String,
    val description: String = "",
    val type: TransactionType = TransactionType.OTHER,
    val sum: Double,
    val sumSubtitle: String = "BBank debit",
    val transactionDate: String = "No info",
)

data class TransactionHistoryDateModel(
    val date: String
)

enum class TransactionType {
    JOB, ENTERTAINMENTS, TECHNIC, CLOTHING, SHOPPING, EDUCATION, FASTFOOD, OTHER
}

fun TransactionType.toStr(context: Context): String {
    return context.getString(
        when (this) {
            TransactionType.JOB -> R.string.transaction_type_job
            TransactionType.ENTERTAINMENTS -> R.string.transaction_type_entertainments
            TransactionType.TECHNIC -> R.string.transaction_type_technic
            TransactionType.CLOTHING -> R.string.transaction_type_clothing
            TransactionType.SHOPPING -> R.string.transaction_type_shopping
            TransactionType.EDUCATION -> R.string.transaction_type_education
            TransactionType.FASTFOOD -> R.string.transaction_type_fastfood
            TransactionType.OTHER -> R.string.transaction_type_other
        }
    )
}