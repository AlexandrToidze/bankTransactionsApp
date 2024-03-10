package com.aiweapps.bbank.ui.screens.toolbar.filter.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aiweapps.bbank.R
import com.aiweapps.bbank.models.TransactionType
import com.aiweapps.bbank.models.toStr
import com.aiweapps.bbank.utils.AppFont

@Composable
fun transactionFilterDropdownItem(
    type: Pair<TransactionType, Boolean>, onClick: ((TransactionType) -> Unit)?
) {
    DropdownMenuItem(text = {
        Text(
            text = type.first.toStr(LocalContext.current),
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }, onClick = {
        onClick?.invoke(type.first)
    }, leadingIcon = {
        if (type.second) {
            Image(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                colorFilter = ColorFilter.tint(Color.White),
                painter = painterResource(id = R.drawable.ic_ok),
                contentDescription = "select transaction filter type in toolbar dropdown menu"
            )
        }
    })
}