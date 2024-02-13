package com.raremode.bankapp.ui.screens.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raremode.bankapp.R
import com.raremode.bankapp.repository.TransactionsHistory
import com.raremode.bankapp.ui.screens.history.items.TransactionHistoryList
import com.raremode.bankapp.ui.screens.toolbar.Toolbar
import com.raremode.bankapp.ui.theme.BankAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TransactionHistoryFragment() {
    val serviceList = TransactionsHistory().getTransactionsHistory()
    var queryString: String by remember { mutableStateOf("") } // Query for SearchBar

    BankAppTheme {

        Column {
            Toolbar()

            SearchBar(modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
                query = queryString,
                onQueryChange = { newQuery ->
                    queryString = newQuery
                },
                colors = SearchBarDefaults.colors(
                    containerColor = colorResource(id = R.color.colorMainGray),
                ),
                leadingIcon = {
                    Icons.Default.Search
                },
                onSearch = {},
                active = false,
                onActiveChange = {}) {

            }
            TransactionHistoryList(serviceList = serviceList)
        }
    }
}