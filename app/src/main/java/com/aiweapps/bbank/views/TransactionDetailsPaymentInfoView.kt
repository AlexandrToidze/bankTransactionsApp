package com.aiweapps.bbank.views

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiweapps.bbank.R
import com.aiweapps.bbank.utils.AppFont

@Composable
fun transactionDetailsPaymentInfoView(from: String, category: String, cashback: String) {
    Row {
        Text(
            //Payment info mocked string
            text = stringResource(id = R.string.payment_info),
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
            .background(colorResource(id = R.color.main_gray))
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))

        transactionDetailsPaymentInfoRow(title = stringResource(id = R.string.payment_from), subtitle = from)
        Divider(
            Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
                .height((1.5).dp)
                .alpha(0.2f), color = colorResource(id = R.color.gray),
        )
        transactionDetailsPaymentInfoRow(title = stringResource(id = R.string.payment_category), subtitle = category)
        Divider(
            Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
                .height((1.5).dp)
                .alpha(0.2f), color = colorResource(id = R.color.gray),
        )
        transactionDetailsPaymentInfoRow(title = stringResource(id = R.string.payment_cashback), subtitle = cashback)

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        transactionDetailsPaymentOption(
            text = stringResource(id = R.string.view_receipt),
            image = R.drawable.ic_receipt
        )

        Spacer(modifier = Modifier.width(16.dp))

        transactionDetailsPaymentOption(
            text = stringResource(id = R.string.split_your_payment),
            image = R.drawable.ic_split_payment
        )
    }
}

@Composable
fun transactionDetailsPaymentInfoRow(title: String, subtitle: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        Text(
            //left string
            text = title,
            color = colorResource(id = R.color.white_gray),
            fontSize = 14.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium
        )

        Text(
            //right string
            text = subtitle,
            color = colorResource(id = R.color.white_gray),
            fontSize = 14.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun transactionDetailsPaymentOption(text: String, image: Int) {
    Column(
        modifier = Modifier
            .width((LocalConfiguration.current.screenWidthDp.dp / 2) - 24.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(colorResource(id = R.color.main_gray))
    ) {
        Image(
            modifier = Modifier
                .clipToBounds()
                .width(54.dp)
                .padding(end = 8.dp, bottom = 16.dp, start = 16.dp, top = 16.dp),
            colorFilter = ColorFilter.tint(colorResource(id = R.color.accent)),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = image),
            contentDescription = "option icon"
        )

        Text(
            //Payment info mocked string
            text = text,
            color = colorResource(id = R.color.white_gray),
            fontSize = 15.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 24.dp, start = 16.dp)
        )
    }

}