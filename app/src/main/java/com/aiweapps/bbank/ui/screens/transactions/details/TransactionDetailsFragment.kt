package com.aiweapps.bbank.ui.screens.transactions.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiweapps.bbank.extensions.isPositiveSum
import com.aiweapps.bbank.extensions.retrieveServiceName
import com.aiweapps.bbank.extensions.toTransactionCashbackForm
import com.aiweapps.bbank.extensions.toTransactionHistoryItemSum
import com.aiweapps.bbank.models.TransactionHistoryModel
import com.aiweapps.bbank.models.toStr
import com.aiweapps.bbank.views.paymentAddressView
import com.aiweapps.bbank.views.transactionDetailsPaymentInfoView
import com.aiweapps.bbank.utils.AppFont

@Composable
fun TransactionDetailsScreen(transactionInfoModel: TransactionHistoryModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        transactionDetailsItem(transactionInfoModel)
    }
}

@Composable
fun transactionDetailsItem(transactionInfoModel: TransactionHistoryModel) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            //.scrollable() use it for enable bottom sheet scrolling
            //start optimize project folders names, files destinations, start planning of api model for my screen data class
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {
        items(1) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .height(96.dp)
                    .width(96.dp)
            ) {

                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = transactionInfoModel.icon),
                    contentDescription = null
                )
            }

            Text(
                //service name
                text = transactionInfoModel.service.retrieveServiceName(),
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = AppFont.Girloy,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )

            Text(
                //transaction date
                text = transactionInfoModel.transactionDate,
                color = Color.Gray,
                fontSize = 15.sp,
                letterSpacing = (0.4).sp,
                fontFamily = AppFont.Girloy,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 6.dp)
            )

            Text(
                //transaction sum
                text = transactionInfoModel.sum.toTransactionHistoryItemSum(),
                color = transactionInfoModel.sum.isPositiveSum(),
                fontSize = 26.sp,
                lineHeight = 28.sp,
                fontFamily = AppFont.Girloy,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 11.dp)
            )

            transactionInfoModel.apply {
                transactionDetailsPaymentInfoView(
                    from = sumSubtitle,
                    category = type.toStr(LocalContext.current),
                    cashback = sum.toTransactionCashbackForm
                        (
                        withCurrency = true,
                        withSign = false
                    )
                )
            }
            paymentAddressView()
        }
    }
}