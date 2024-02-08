package com.raremode.bankapp.ui.theme.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raremode.bankapp.R
import com.raremode.bankapp.utils.AppFont

@Composable
fun Toolbar() {
    Row(
        Modifier
            .background(Color.Black)
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
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp)
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

            Image(
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
                    .padding(start = 8.dp),
                colorFilter = ColorFilter.tint(Color.White),
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "filter transactions"
            )
        }
    }
}