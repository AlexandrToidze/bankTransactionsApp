package com.raremode.bankapp.ui.screens.history

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.raremode.bankapp.repository.TransactionsHistory
import com.raremode.bankapp.ui.screens.history.items.TransactionHistoryList
import com.raremode.bankapp.ui.screens.toolbar.Toolbar
import com.raremode.bankapp.ui.theme.BankAppTheme

@Composable
fun TransactionHistoryFragment(navController: NavHostController) {
    val serviceList = TransactionsHistory().getTransactionsHistory()
    var queryString = ""

    BankAppTheme {

        Column {
            Toolbar()

//            SearchBar(modifier = Modifier
//                .height(50.dp)
//                .padding(16.dp),
//                query = "",
//                onQueryChange = { newQuery ->
//                    queryString = newQuery
//                },
//                onSearch = {},
//                active = false,
//                onActiveChange = {}) {
//
//            }
            TransactionHistoryList(serviceList = serviceList, navController)
        }
    }
}