package com.raremode.bankapp.ui.screens.history.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.utils.AppFont
import com.raremode.bankapp.utils.Constants
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.Currency
import java.util.Locale

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TransactionHistoryItem(
    serviceModel: TransactionHistoryModel,
    color: Color = Color.Gray,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .height(60.dp)
            .clickable {
                navController.navigate(
                    route = "details_screen"
                            + "/${URLEncoder.encode(serviceModel.service, StandardCharsets.UTF_8.toString())}"
                            + "/${serviceModel.type}"
                            + "/${serviceModel.sum}"
                            + "/${serviceModel.sumSubtitle}"
                            + "/${serviceModel.transactionDate}"
                )
            }
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
                .clip(CircleShape)
                .background(color)
                .height(24.dp)
                .width(24.dp)
        ) {

            GlideImage(
                model = "${Constants.GLIDE_ICONS_LOAD_URL}${serviceModel.service}",
                contentDescription = "null",
                contentScale = ContentScale.Crop
            )

//            Text(
//                text = service,
//                modifier = Modifier
//                    .align(Alignment.Center)
//            )
        }

        Spacer(modifier = Modifier.width(6.dp))

        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = serviceModel.service.toUri().authority.toString()
                        .dropLastWhile { it != '.' },
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight.Normal
                )
                val sum = String.format(
                    "%.2f ${Currency.getInstance(Locale.getDefault()).symbol}",
                    serviceModel.sum
                )
                val formattedTransactionSum = if (serviceModel.sum > 0) "+$sum"
                else sum

                Text(
                    text = formattedTransactionSum,
                    color = if (serviceModel.sum > 0) Color.Green else Color.White,
                    fontSize = 20.sp,
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = serviceModel.type,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight.Light
                )

                Text(
                    text = serviceModel.sumSubtitle,
                    color = Color.Gray,
                    textAlign = TextAlign.End,
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight.Light
                )
            }

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(12.dp)
//                    .clip(shape = RoundedCornerShape(2.dp))
//                    .background(color)
//            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}