package com.raremode.bankapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raremode.bankapp.repository.TransactionsHistory
import com.raremode.bankapp.ui.theme.BankAppTheme
import com.raremode.bankapp.ui.theme.items.Toolbar
import com.raremode.bankapp.ui.theme.items.TransactionHistoryList

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TransactionScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TransactionScreen() {
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
            TransactionHistoryList(serviceList = serviceList)
        }
    }
}