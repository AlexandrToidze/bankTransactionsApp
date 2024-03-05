package com.raremode.bankapp.ui.screens.history

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raremode.bankapp.repository.TransactionsHistory
import com.raremode.bankapp.ui.screens.history.items.TransactionHistoryList
import com.raremode.bankapp.ui.screens.toolbar.Toolbar
import com.raremode.bankapp.ui.theme.BankAppTheme

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