package com.raremode.bankapp.ui.screens.details.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raremode.bankapp.R
import com.raremode.bankapp.utils.AppFont

@Composable
fun paymentInfo(from: String, category: String, cashback: String) {
    Row {
        Text(
            //Payment info mocked string
            text = "Payment info",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(top = 36.dp, bottom = 18.dp)
                .fillMaxWidth()
        )
    }

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(colorResource(id = R.color.colorMainGray))
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))

        paymentInfoRow(title = "Payment from", subtitle = from)
        Divider(
            Modifier
                .fillMaxWidth(0.98f)
                .height(1.dp)
                .alpha(0.5f), color = colorResource(id = R.color.colorGray),
        )
        paymentInfoRow(title = "Categories", subtitle = category)
        Divider(
            Modifier
                .fillMaxWidth(0.98f)
                .height(1.dp)
                .alpha(0.5f), color = colorResource(id = R.color.colorGray)
        )
        paymentInfoRow(title = "Cashback", subtitle = cashback)

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))
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
            color = colorResource(id = R.color.colorWhiteGray),
            fontSize = 14.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium
        )

        Text(
            //right string
            text = subtitle,
            color = colorResource(id = R.color.colorWhiteGray),
            fontSize = 14.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun paymentOption(text: String, image: Int) {
    Column(
        modifier = Modifier
            .width(180.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(colorResource(id = R.color.colorMainGray))
    ) {
        Image(
            modifier = Modifier
                .clipToBounds()
                .height(60.dp)
                .width(60.dp)
                .padding(end = 8.dp, bottom = 16.dp, start = 16.dp, top = 12.dp),
            colorFilter = ColorFilter.tint(colorResource(id = R.color.colorAccent)),
            painter = painterResource(id = image),
            contentDescription = "budget chart"
        )

        Text(
            //Payment info mocked string
            text = text,
            color = colorResource(id = R.color.colorWhiteGray),
            fontSize = 14.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 24.dp, start = 16.dp)
        )
    }

}