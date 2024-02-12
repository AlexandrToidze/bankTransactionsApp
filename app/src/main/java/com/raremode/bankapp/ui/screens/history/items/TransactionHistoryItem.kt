package com.raremode.bankapp.ui.screens.history.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.ui.screens.details.TransactionDetailsScreen
import com.raremode.bankapp.utils.AppFont
import com.raremode.bankapp.utils.Constants
import java.util.Currency
import java.util.Locale

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TransactionHistoryItem(
    serviceModel: TransactionHistoryModel,
    color: Color = Color.Gray,
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showBottomSheet: Boolean by remember { mutableStateOf(false) }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .clickable {
                showBottomSheet = true
            }
    ) {

        if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = Color.Black,
                modifier = Modifier.fillMaxHeight(0.9f),
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                TransactionDetailsScreen(serviceModel)
            }
        }

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Black)
                .height(48.dp)
                .width(48.dp)
                .align(Alignment.CenterVertically)
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
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .align(Alignment.CenterVertically)
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