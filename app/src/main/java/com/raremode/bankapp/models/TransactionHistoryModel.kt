package com.raremode.bankapp.models

data class TransactionHistoryModel(
    val service: String,
    val type: TransactionType = TransactionType.OTHER,
    val sum: Double,
    val sumSubtitle: String = "BBank debit",
    val transactionDate: String = "No info",
)

data class TransactionHistoryDateModel(
    val date: String
)

enum class TransactionType {
    JOB, ENTERTAINMENTS, TECHNIC, CLOTHING, SHOPPING, EDUCATION, OTHER
}

fun TransactionType.toStr() : String {
    return when (this) {
        TransactionType.JOB -> "Job"
        TransactionType.ENTERTAINMENTS -> "Entertainments"
        TransactionType.TECHNIC -> "Technic"
        TransactionType.CLOTHING -> "Clothing"
        TransactionType.SHOPPING -> "Shopping"
        TransactionType.EDUCATION -> "Education"
        TransactionType.OTHER -> "Other"
        else -> "Other"
    }
}