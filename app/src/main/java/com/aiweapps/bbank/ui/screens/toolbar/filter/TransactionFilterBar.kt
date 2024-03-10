package com.aiweapps.bbank.ui.screens.toolbar.filter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiweapps.bbank.R
import com.aiweapps.bbank.models.TransactionType
import com.aiweapps.bbank.models.toStr
import com.aiweapps.bbank.ui.screens.toolbar.filter.items.transactionFilterBarItem
import com.aiweapps.bbank.ui.viewmodels.TransactionFilterViewModel
import com.aiweapps.bbank.utils.AppFont

@Preview
@Composable
fun TransactionFilterBar(
    viewModel: TransactionFilterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val selectedFilterTypes: List<Pair<TransactionType, Boolean>> =
        viewModel.state.collectAsState().value.selectedFilterTypes

    Row(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
//                .fillMaxWidth(0.2f)
                .padding(end = 12.dp),
            fontFamily = AppFont.Girloy,
            color = colorResource(id = R.color.gray),
            fontWeight = FontWeight.Medium,
            text = stringResource(id = R.string.transaction_filter_bar_categories_title),
            fontSize = 14.sp
        )

        LazyRow(modifier = Modifier
            .fillMaxWidth(0.78f)
            ,
            content = {
                items(count = selectedFilterTypes.size - 1) { index ->
                    if (selectedFilterTypes[index].second) {
                        transactionFilterBarItem(
                            text = selectedFilterTypes[index].first.toStr(LocalContext.current),
                            itemPadding = if (index != 0) 4 else 0,
                            onClick = {
                                viewModel.updateFilterByThisType(selectedFilterTypes[index].first)
                            }
                        )
                    }
                }
            })

        Spacer(modifier = Modifier.weight(0.1f))

        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .width(106.dp)
                .clickable {
                    viewModel.clearAllFilters()
                },
            maxLines = 1,
            color = colorResource(id = R.color.gray),
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            text = stringResource(id = R.string.transaction_filter_bar_clear_all),
            fontSize = 12.sp
        )

    }
}