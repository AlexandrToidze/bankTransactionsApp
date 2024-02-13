package com.raremode.bankapp.models

data class TransactionHistoryModel(
    val service: String,
    val type: String = "Other",
    val sum: Double,
    val sumSubtitle: String = "BBank debit",
    val transactionDate: String = "No info",
)

data class TransactionHistoryDateModel(
    val date: String
)