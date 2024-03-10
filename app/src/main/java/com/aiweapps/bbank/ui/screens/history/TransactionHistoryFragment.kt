package com.aiweapps.bbank.ui.screens.history

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aiweapps.bbank.repository.TransactionsHistory
import com.aiweapps.bbank.ui.screens.history.items.TransactionHistoryList
import com.aiweapps.bbank.ui.screens.toolbar.Toolbar

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TransactionHistoryFragment() {
    val serviceList = TransactionsHistory().getTransactionsHistory()

    //BankAppTheme {

        Column {
            Toolbar()
            TransactionHistoryList(serviceList = serviceList)
        }
    //}
}