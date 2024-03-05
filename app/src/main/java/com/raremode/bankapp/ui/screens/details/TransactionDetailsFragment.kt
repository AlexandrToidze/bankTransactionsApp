package com.raremode.bankapp.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raremode.bankapp.R
import com.raremode.bankapp.extensions.dropSignsFromSum
import com.raremode.bankapp.extensions.isPositiveSum
import com.raremode.bankapp.extensions.retrieveServiceName
import com.raremode.bankapp.extensions.toCurrencyString
import com.raremode.bankapp.extensions.toTransactionHistoryItemSum
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.models.toStr
import com.raremode.bankapp.ui.screens.details.items.paymentInfo
import com.raremode.bankapp.ui.screens.details.items.paymentOption
import com.raremode.bankapp.utils.AppFont
import kotlin.math.abs

@Composable
fun TransactionDetailsScreen(transactionInfoModel: TransactionHistoryModel) {
//    BankAppTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
//                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Divider(
//                Modifier
//                    .width(40.dp)
//                    .height(12.dp)
//                    .padding(top = 8.dp)
//                    .clip(shape = RoundedCornerShape(4.dp)),
//                color = Color.White
//            )
            transactionDetailsItem(transactionInfoModel)
        }
//    }
}

@Composable
fun transactionDetailsItem(transactionInfoModel: TransactionHistoryModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Black)
                .height(96.dp)
                .width(96.dp)
        ) {

//            AsyncImage(
//                model = "${Constants.GLIDE_ICONS_LOAD_URL}${transactionInfoModel.service}",
//                contentDescription = "use Coil for load image for transaction details",
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .fillMaxWidth()
//            )

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
            modifier = Modifier.padding(top = 12.dp)
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
            modifier = Modifier.padding(top = 12.dp)
        )

        transactionInfoModel.apply {
            paymentInfo(
                from = sumSubtitle,
                category = type.toStr(),
                cashback = if (sum < 0) abs(sum / 100).toCurrencyString().dropSignsFromSum()
                else "-  "
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            paymentOption(text = "View receipt", image = R.drawable.ic_receipt)
            Spacer(modifier = Modifier.width(16.dp))
            paymentOption(text = "Split your payment", image = R.drawable.ic_split_payment)
        }
    }
}