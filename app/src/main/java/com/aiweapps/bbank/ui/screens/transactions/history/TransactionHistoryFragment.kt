package com.aiweapps.bbank.ui.screens.transactions.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aiweapps.bbank.views.CustomSearchBar
import com.aiweapps.bbank.models.TransactionHistoryDateModel
import com.aiweapps.bbank.models.TransactionHistoryModel
import com.aiweapps.bbank.models.TransactionType
import com.aiweapps.bbank.repository.TransactionsHistory
import com.aiweapps.bbank.ui.screens.toolbar.Toolbar
import com.aiweapps.bbank.ui.screens.toolbar.filter.TransactionFilterBar
import com.aiweapps.bbank.ui.screens.transactions.history.items.TransactionHistoryDateItem
import com.aiweapps.bbank.ui.screens.transactions.history.items.TransactionHistoryItem
import com.aiweapps.bbank.ui.viewmodels.TransactionFilterViewModel

@Preview(showBackground = true)
@Composable
fun TransactionHistoryFragment() {
        Column {
            Toolbar()
            TransactionHistoryList()
        }
}

@Composable
fun TransactionHistoryList(
    viewModel: TransactionFilterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val serviceList = TransactionsHistory().getTransactionsHistory()

    val filterTypes: List<Pair<TransactionType, Boolean>> =
        viewModel.state.collectAsState().value.selectedFilterTypes
    var queryString: String by remember { mutableStateOf("") } // Query for SearchBar
    var filteredList = filterServiceList(serviceList, queryString, filterTypes)

    LazyColumn(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(filteredList.size + 2) { position ->
            when (position) {
                0 -> {
                    CustomSearchBar(onChangeQuery = {
                        queryString = it
                        filteredList = filterServiceList(serviceList, queryString, filterTypes)
                    },
                        modifier = Modifier.padding(start = 16.dp, end = 20.dp))
                }

                1 -> {
                    if (!filterTypes.all { !it.second }) TransactionFilterBar()
                }

                else -> {
                    println("Build item at position $position")

                    Row(horizontalArrangement = Arrangement.Center) {
                        when (filteredList[position - 2]) {
                            is TransactionHistoryModel -> {
                                TransactionHistoryItem(
                                    serviceModel = filteredList[position - 2]
                                            as TransactionHistoryModel
                                )
                            }

                            is TransactionHistoryDateModel -> {
                                if (checkIfNeedDateSection(filteredList, position - 2)) {
                                    TransactionHistoryDateItem(
                                        date = (filteredList[position - 2]
                                                as TransactionHistoryDateModel).date
                                    )
                                }
                            }

                            else -> Unit
                        }
                    }

                    Spacer(modifier = Modifier.height(1.dp))
                }
            }
        }
    }
}

fun filterServiceList(
    list: List<Any>, query: String, filterTypes: List<Pair<TransactionType, Boolean>>
): List<Any> {
    val isDefaultFilter = filterTypes.all { !it.second } //if all filter types are inactive

    return if (!isDefaultFilter) { //implemented sort by selected filter types
        list.filter {
            (it is TransactionHistoryModel && it.service.contains(
                query, true
            ) && filterTypes.contains(Pair(it.type, true))
                    ) || it is TransactionHistoryDateModel
        }
    } else {
        list.filter { //case for first open screen
            (it is TransactionHistoryModel && it.service.contains(
                query,
                true
            )) || it is TransactionHistoryDateModel
        }
    }
}

fun checkIfNeedDateSection(list: List<Any>, currentPosition: Int) =
    !(currentPosition == list.size - 1 || list[currentPosition + 1] is TransactionHistoryDateModel)