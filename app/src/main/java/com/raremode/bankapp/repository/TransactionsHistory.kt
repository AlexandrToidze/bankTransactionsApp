package com.raremode.bankapp.repository

import com.raremode.bankapp.R
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
                icon = R.drawable.figma_logo,
                service = "http://figma.com/",
                sum = (20140.74),
                type = JOB,
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.facebook_logo,
                service = "http://facebook.com/",
                sum = (-379.21),
                type = ENTERTAINMENTS,
                sumSubtitle = "BBank credit",
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.google_logo,
                service = "http://google.com/",
                sum = (520.89),
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryDateModel(
                date = "Yesterday"
            ),

            TransactionHistoryModel(
                icon = R.drawable.nike_logo,
                service = "http://nike.com/",
                sum = (-8652.10),
                type = CLOTHING,
                transactionDate = "February 12, 19:21 a.m."

            ),

            TransactionHistoryModel(
                icon = R.drawable.wallmart_logo,
                service = "http://wallmart.com/",
                sum = (201.40),
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.instagram_logo,
                service = "http://instagram.com/",
                sum = (37693.09),
                type = JOB,
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.bk_logo,
                service = "https://Burger king.com/",
                sum = (-662.73),
                type = FASTFOOD,
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryDateModel(
                date = "Later"
            ),

            TransactionHistoryModel(
                icon = R.drawable.apple_logo,
                service = "http://apple.com/",
                sum = (-80124.53),
                type = TECHNIC,
                transactionDate = "February 12, 18:22 a.m."

            ),

            TransactionHistoryModel(
                icon = R.drawable.figma_logo,
                service = "http://figma.com/",
                sum = (985.12),
                type = EDUCATION,
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.adidas_logo,
                service = "http://Adidas.com/",
                sum = (-16096.31),
                type = SHOPPING,
                transactionDate = "February 12, 19:21 a.m."

            ),
        )
    }
}