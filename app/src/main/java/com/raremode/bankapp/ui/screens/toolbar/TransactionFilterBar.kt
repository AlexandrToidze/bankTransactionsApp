package com.raremode.bankapp.ui.screens.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raremode.bankapp.R
import com.raremode.bankapp.models.TransactionType
import com.raremode.bankapp.models.toStr
import com.raremode.bankapp.ui.screens.toolbar.items.transactionFilterBarItem
import com.raremode.bankapp.ui.viewmodels.TransactionFilterViewModel
import com.raremode.bankapp.utils.AppFont

@Preview
@Composable
fun TransactionFilterBar(
    viewModel: TransactionFilterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val selectedFilterTypes: List<Pair<TransactionType, Boolean>> =
        viewModel.state.collectAsState().value.selectedFilterTypes

    Row(
        modifier = Modifier
            .padding(top = 12.dp, start = 16.dp, end = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.26f)
                .padding(end = 12.dp),
            fontFamily = AppFont.Girloy,
            color = colorResource(id = R.color.colorGray),
            fontWeight = FontWeight.Medium,
            text = "Categories: ",
            fontSize = 14.sp
        )

        LazyRow(modifier = Modifier
            .fillMaxWidth(0.74f),
            content = {
                items(count = selectedFilterTypes.size - 1) { index ->
                    if (selectedFilterTypes[index].second) {
                        transactionFilterBarItem(
                            text = selectedFilterTypes[index].first.toStr(),
                            itemPadding = if (index != 0) 8 else 0,
                            onClick = {
                                viewModel.updateFilterByThisType(selectedFilterTypes[index].first)
                            }
                        )
                    }
                }
            })

        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .width(56.dp)
                .clickable {
                    viewModel.clearAllFilters()
                },
            color = colorResource(id = R.color.colorGray),
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            text = "Clear all",
            fontSize = 12.sp
        )

    }
}