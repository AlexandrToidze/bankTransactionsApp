package com.raremode.bankapp.repository

import com.raremode.bankapp.R
import com.raremode.bankapp.models.TransactionHistoryDateModel
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.models.TransactionType.CLOTHING
import com.raremode.bankapp.models.TransactionType.EDUCATION
import com.raremode.bankapp.models.TransactionType.ENTERTAINMENTS
import com.raremode.bankapp.models.TransactionType.FASTFOOD
import com.raremode.bankapp.models.TransactionType.JOB
import com.raremode.bankapp.models.TransactionType.SHOPPING
import com.raremode.bankapp.models.TransactionType.TECHNIC

class TransactionsHistory() {
    fun getTransactionsHistory(): List<Any> {
        return listOf(
            TransactionHistoryDateModel(
                date = "Today"
            ),

            TransactionHistoryModel(
                icon = R.drawable.ebay_logo,
                service = "http://ebay.com/",
                sum = (2140.74),
                type = JOB,
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.facebook_logo,
                service = "http://facebook.com/",
                sum = (-90.20),
                type = ENTERTAINMENTS,
                sumSubtitle = "BBank credit",
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.google_logo,
                service = "http://google.com/",
                sum = (-121.22),
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryDateModel(
                date = "Yesterday"
            ),

            TransactionHistoryModel(
                icon = R.drawable.nike_logo,
                service = "http://nike.com/",
                sum = (-238.10),
                type = CLOTHING,
                transactionDate = "February 12, 19:21 a.m."

            ),

            TransactionHistoryModel(
                icon = R.drawable.wallmart_logo,
                service = "http://wallmart.com/",
                sum = (-207.40),
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.ebay_logo,
                service = "http://ebay.com/",
                description = "Sales revenue",
                sum = (3169.46),
                type = JOB,
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.bk_logo,
                service = "https://Burger king.com/",
                sum = (-60.00),
                type = FASTFOOD,
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryDateModel(
                date = "March 5"
            ),

            TransactionHistoryModel(
                icon = R.drawable.apple_logo,
                service = "http://apple.com/",
                sum = (-2471.53),
                type = TECHNIC,
                transactionDate = "February 12, 18:22 a.m."

            ),

            TransactionHistoryModel(
                icon = R.drawable.figma_logo,
                service = "http://figma.com/",
                sum = (-9.12),
                type = EDUCATION,
                transactionDate = "February 13, 12:43 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.adidas_logo,
                service = "http://Adidas.com/",
                sum = (-169.31),
                type = SHOPPING,
                transactionDate = "February 12, 19:21 a.m."
            ),


            TransactionHistoryDateModel(
                date = "Later"
            ),

            TransactionHistoryModel(
                icon = R.drawable.wallmart_logo,
                service = "http://wallmart.com/",
                type = SHOPPING,
                sum = (-134.00),
                transactionDate = "February 12, 19:21 a.m."
            ),

            TransactionHistoryModel(
                icon = R.drawable.google_logo,
                service = "http://google.com/",
                sum = (-98.00),
                transactionDate = "February 13, 12:43 a.m."
            ),
        )
    }
}