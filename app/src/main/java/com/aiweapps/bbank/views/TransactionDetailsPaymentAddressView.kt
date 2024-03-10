package com.aiweapps.bbank.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun paymentAddressView() {
    Row {
        Text(
            //Payment address mocked string
            text = stringResource(id = R.string.payment_address),
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(vertical = 18.dp)
                .fillMaxWidth()
        )
    }

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(colorResource(id = R.color.main_gray))
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Text(
            //left string
            modifier = Modifier.padding(vertical = 12.dp),
            text = "11b W 27th St, New York, NY 10001",
            color = colorResource(id = R.color.white_gray),
            fontSize = 14.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.SemiBold
        )

        Box(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(colorResource(id = R.color.gray))
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_map),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .scale(1.8f)
                    .fillMaxWidth()
            )
        }
    }
}