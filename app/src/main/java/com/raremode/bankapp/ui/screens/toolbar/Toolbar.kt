package com.raremode.bankapp.ui.screens.toolbar

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raremode.bankapp.R
import com.raremode.bankapp.extensions.isFilterByThisType
import com.raremode.bankapp.models.TransactionType
import com.raremode.bankapp.models.toStr
import com.raremode.bankapp.ui.viewmodels.TransactionFilterVM
import com.raremode.bankapp.utils.AppFont

@Composable
fun Toolbar(
    viewModel: TransactionFilterVM = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var expandedFilterMenu: Boolean by remember { mutableStateOf(false) }

//    var selectedFilterTypes: List<Pair<TransactionType, Boolean>> by remember { mutableStateOf( listOf<Pair<TransactionType, Boolean>>().initFilterList() ) }
    val selectedFilterTypes: List<Pair<TransactionType, Boolean>> = viewModel.state.collectAsState().value.selectedFilterTypes

    Row(
        Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp),
            colorFilter = ColorFilter.tint(Color.White),
            painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = "quit from screen"
        )

        Text(
            text = "Transactions",
            color = Color.White,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 32.dp)
        )

        Row {
            Image(
                modifier = Modifier
                    .clipToBounds()
                    .height(36.dp)
                    .width(36.dp)
                    .padding(end = 8.dp),
                colorFilter = ColorFilter.tint(Color.White),
                painter = painterResource(id = R.drawable.ic_chart),
                contentDescription = "budget chart"
            )

            IconButton(
                onClick = {
                    expandedFilterMenu = !expandedFilterMenu
                },
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
                    .padding(start = 8.dp),
//                colorFilter = ColorFilter.tint(Color.White),
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor =
                    if (selectedFilterTypes.all { !it.second }) Color.White
                    else colorResource(id = R.color.colorAccent)
                ),
//                painter = painterResource(id = R.drawable.ic_filter),
//                contentDescription = "filter transactions"
            ) {
                Icon(painterResource(id = R.drawable.ic_filter), contentDescription = null)
            }

            DropdownMenu(
                expanded = expandedFilterMenu,
                onDismissRequest = { expandedFilterMenu = false },
                modifier = Modifier.background(colorResource(id = R.color.colorMainGray))
            ) {
               selectedFilterTypes.forEach { type ->
                    DropdownMenuItem(
                        text = { Text(text = type.first.toStr(), color = Color.White) },
                        onClick = {
                                  viewModel.updateFilterByThisType(type.first)
                            Log.d("SelectedFilterTypes", viewModel.state.value.selectedFilterTypes.toString())
                                  },
                        leadingIcon = {
                            if (viewModel.state.value.selectedFilterTypes.isFilterByThisType(type.first)) {
                                Image(
                                    modifier = Modifier
                                        .height(32.dp)
                                        .width(32.dp),
                                    colorFilter = ColorFilter.tint(Color.White),
                                    painter = painterResource(id = R.drawable.ic_search),
                                    contentDescription = "quit from screen"
                                )
                            }
                        })
                }
            }
        }
    }
}