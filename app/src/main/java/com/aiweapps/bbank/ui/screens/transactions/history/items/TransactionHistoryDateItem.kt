package com.aiweapps.bbank.ui.screens.transactions.history.items

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiweapps.bbank.utils.AppFont

@Composable
fun TransactionHistoryDateItem(date: String = "Today") {
    Text(
        text = date,
        color = Color.White,
        fontFamily = AppFont.Girloy,
        letterSpacing = (0.05).sp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(start = 20.dp, top = 14.dp, bottom = 6.dp)
    )
}