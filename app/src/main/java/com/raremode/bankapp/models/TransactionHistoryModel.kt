package com.raremode.bankapp.models

data class TransactionHistoryModel(
    val service: String,
    val type: String = "No info",
    val sum: Double,
    val sumSubtitle: String = "Bank debit",
    val transactionDate: String = "No info",
)

data class TransactionHistoryDateModel(
    val date: String
)