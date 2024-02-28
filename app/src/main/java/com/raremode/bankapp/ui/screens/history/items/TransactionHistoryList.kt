package com.raremode.bankapp.ui.screens.history.items

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.raremode.bankapp.R
import com.raremode.bankapp.models.TransactionHistoryDateModel
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.models.TransactionType
import com.raremode.bankapp.ui.screens.toolbar.TransactionFilterBar
import com.raremode.bankapp.ui.viewmodels.TransactionFilterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionHistoryList(
    serviceList: List<Any>,
    viewModel: TransactionFilterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
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
                    SearchBar(modifier = Modifier
                        .height(70.dp)
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
                        query = queryString,
                        onQueryChange = { newQuery ->
                            queryString = newQuery
                            filteredList = filterServiceList(serviceList, queryString, filterTypes)
                            Log.d("refreshQuery", filteredList.size.toString())
                        },
                        colors = SearchBarDefaults.colors(
                            containerColor = colorResource(id = R.color.colorMainGray),
                            dividerColor = Color.White,
                            inputFieldColors = TextFieldDefaults.colors(
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                focusedLeadingIconColor = colorResource(id = R.color.colorGray),
                                unfocusedLeadingIconColor = colorResource(id = R.color.colorGray)
                            )
                        ),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        },
                        onSearch = {},
                        active = false,
                        onActiveChange = {}) {

                    }
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

                    Spacer(modifier = Modifier.height(4.dp))
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
