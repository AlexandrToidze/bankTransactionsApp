package com.raremode.bankapp.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raremode.bankapp.R
import com.raremode.bankapp.extensions.isPositiveSum
import com.raremode.bankapp.extensions.retrieveServiceName
import com.raremode.bankapp.extensions.toCurrencyString
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.repository.TransactionsHistory
import com.raremode.bankapp.ui.screens.details.items.paymentInfo
import com.raremode.bankapp.ui.screens.details.items.paymentOption
import com.raremode.bankapp.ui.theme.BankAppTheme
import com.raremode.bankapp.utils.AppFont
import com.raremode.bankapp.utils.Constants

@Composable
fun TransactionDetailsScreen(service: String,
                             type: String,
                             sum: Double,
                             subtitle: String,
                             trDate: String) {
    val model = TransactionHistoryModel(service, type, sum, subtitle, trDate)
    BankAppTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(
                Modifier
                    .width(40.dp)
                    .height(12.dp)
                    .padding(top = 8.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                color = Color.White
            )
            transactionDetailsItem(model)
        }
    }
}

@Composable
fun transactionDetailsItem(transactionInfoModel: TransactionHistoryModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 36.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Gray)
                .height(96.dp)
                .width(96.dp)
        ) {

            AsyncImage(
                model = "${Constants.GLIDE_ICONS_LOAD_URL}${transactionInfoModel.service}",
                contentDescription = "use Coil for load image for transaction details"
            )
        }

        Text(
            //service name
            text = transactionInfoModel.service.retrieveServiceName(),
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 12.dp)
        )

        Text(
            //transaction date
            text = transactionInfoModel.transactionDate,
            color = Color.Gray,
            fontSize = 20.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 12.dp)
        )

        Text(
            //transaction sum
            text = transactionInfoModel.sum.toCurrencyString(),
            color = transactionInfoModel.sum.isPositiveSum(),
            fontSize = 26.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 16.dp)
        )

        transactionInfoModel.apply {
            paymentInfo(
                from = sumSubtitle,
                category = type,
                cashback = (sum / 100).toCurrencyString()
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            paymentOption(text = "View receipt", image = R.drawable.ic_chart)
            paymentOption(text = "Split your payment", image = R.drawable.ic_filter)
        }
    }
}