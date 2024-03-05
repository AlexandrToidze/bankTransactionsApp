package com.raremode.bankapp.ui.screens.toolbar.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raremode.bankapp.R
import com.raremode.bankapp.utils.AppFont

@Composable
fun transactionFilterBarItem(text: String, onClick: (() -> Unit), itemPadding: Int) {
    Row(
        modifier = Modifier
            .padding(start = itemPadding.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.colorMainGray))
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(0.dp, 5.dp)
            ) {
            Text(
                modifier = Modifier
//                    .background(colorResource(id = R.color.colorAccent))
                    .padding(8.dp, 0.dp, 1.dp, 0.dp),
                fontFamily = AppFont.Girloy,
                color = colorResource(id = R.color.colorGray),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                text = text
            )
            Icon(
                modifier = Modifier
//                    .background(Color.Red)
                    .padding(end = 8.dp)
                    .height(14.dp)
                    .width(14.dp),
                tint = colorResource(id = R.color.colorGray),
                imageVector = Icons.Default.Close, contentDescription = null
            )
        }
    }
}