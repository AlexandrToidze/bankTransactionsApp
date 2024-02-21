package com.raremode.bankapp.repository

import com.raremode.bankapp.models.TransactionHistoryDateModel
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.models.TransactionType.*

class TransactionsHistory() {
    fun getTransactionsHistory(): List<Any> {
        return listOf(
            TransactionHistoryDateModel(
                date = "Today"
            ),

            TransactionHistoryModel(
                service = "http://figma.com/",
                sum = (201.74),
                type = JOB,
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                service = "http://vk.com/",
                sum = (379.21),
                type = ENTERTAINMENTS,
                sumSubtitle = "BBank credit",
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                service = "http://google.com/",
                sum = (520.89),
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryDateModel(
                date = "Yesterday"
            ),

            TransactionHistoryModel(
                service = "http://ozon.com/",
                sum = (-852.10),
                type = CLOTHING,
                transactionDate = "February 12, 19:21 a.m."

            ),

            TransactionHistoryModel(
                service = "http://figma.com/",
                sum = (201.40),
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                service = "http://vk.com/",
                sum = (379.29),
                type = JOB,
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                service = "https://vk.com/",
                sum = (520.73),
                type = EDUCATION,
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                service = "http://apple.com/",
                sum = (-80000.0),
                type = TECHNIC,
                transactionDate = "February 12, 18:22 a.m."

            ),

            TransactionHistoryDateModel(
                date = "Later"
            ),

            TransactionHistoryModel(
                service = "http://figma.com/",
                sum = (589.12),
                type = EDUCATION,
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                service = "http://ozon.com/",
                sum = (-1094.71),
                type = SHOPPING,
                transactionDate = "February 12, 19:21 a.m."

            ),
        )
    }
}