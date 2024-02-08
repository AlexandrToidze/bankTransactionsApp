package com.raremode.bankapp.ui.screens.history.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.raremode.bankapp.models.TransactionHistoryDateModel
import com.raremode.bankapp.models.TransactionHistoryModel

@Composable
fun TransactionHistoryList(serviceList: List<Any>) {
    LazyColumn(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        items(6) { position ->

            println("Build item at position $position")

            Row(horizontalArrangement = Arrangement.Center) {
                when (serviceList[position]) {
                    is TransactionHistoryModel -> {
                        TransactionHistoryItem(
                            serviceModel = serviceList[position]
                                    as TransactionHistoryModel
                        )
                    }

                    is TransactionHistoryDateModel -> {
                        TransactionHistoryDateItem(
                            date = (serviceList[position]
                                    as TransactionHistoryDateModel).date
                        )
                    }

                    else -> Unit
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
        }


    }
}