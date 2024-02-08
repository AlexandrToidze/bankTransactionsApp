package com.raremode.bankapp.repository

import com.raremode.bankapp.models.TransactionHistoryDateModel
import com.raremode.bankapp.models.TransactionHistoryModel

class TransactionsHistory() {
    fun getTransactionsHistory(): List<Any> {
        return listOf(
            TransactionHistoryDateModel(
                date = "Today"
            ),

            TransactionHistoryModel(
                service = "http://figma.com/",
                sum = (201.0)
            ),

            TransactionHistoryModel(
                service = "http://vk.com/",
                sum = (379.0)
            ),

            TransactionHistoryModel(
                service = "http://google.com/",
                sum = (520.0)
            ),

            TransactionHistoryDateModel(
                date = "Yesterday"
            ),

            TransactionHistoryModel(
                service = "http://facebook.com/",
                sum = (-800.0)
            ),

            TransactionHistoryModel(
                service = "http://figma.com/",
                sum = (201.0)
            ),

            TransactionHistoryModel(
                service = "http://vk.com/",
                sum = (379.0)
            ),

            TransactionHistoryModel(
                service = "https://vk.com/",
                sum = (520.0)
            ),

            TransactionHistoryModel(
                service = "http://facebook.com/",
                sum = (-800.0)
            ),
        )
    }
}