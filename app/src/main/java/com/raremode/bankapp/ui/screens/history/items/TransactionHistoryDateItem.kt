package com.raremode.bankapp.ui.screens.history.items

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raremode.bankapp.utils.AppFont

@Composable
fun TransactionHistoryDateItem(date: String = "Today") {
    Text(
        text = date,
        color = Color.White,
        fontFamily = AppFont.Girloy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(start = 16.dp, top = 12.dp, bottom = 4.dp)
    )
}