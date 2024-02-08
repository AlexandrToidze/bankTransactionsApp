package com.raremode.bankapp.ui.screens.details.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
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
fun paymentInfo(from: String, category: String, cashback: String) {
    Row {
        Text(
            //Payment info mocked string
            text = "Transaction info",
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 36.dp, bottom = 12.dp)
        )
    }

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        paymentInfoRow(title = "Payment from", subtitle = from)
        Divider(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .alpha(0.5f), color = Color.White
        )
        paymentInfoRow(title = "Categories", subtitle = category)
        Divider(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .alpha(0.5f), color = Color.White
        )
        paymentInfoRow(title = "Cashback", subtitle = cashback)
    }
}

@Composable
fun paymentInfoRow(title: String, subtitle: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        Text(
            //left string
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Normal
        )

        Text(
            //right string
            text = subtitle,
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun paymentOption(text: String, image: Int) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(64.dp))
            .padding(top = 16.dp, bottom = 16.dp)
            .background(Color.DarkGray)
    ) {
        Image(
            modifier = Modifier
                .clipToBounds()
                .height(72.dp)
                .width(72.dp)
                .padding(end = 8.dp, bottom = 24.dp, start = 16.dp),
            colorFilter = ColorFilter.tint(Color.Green),
            painter = painterResource(id = R.drawable.ic_chart),
            contentDescription = "budget chart"
        )

        Text(
            //Payment info mocked string
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 12.dp, start = 16.dp)
        )
    }

}