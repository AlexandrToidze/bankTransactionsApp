package com.aiweapps.bbank.ui.screens.transactions.history.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiweapps.bbank.R
import com.aiweapps.bbank.extensions.isPositiveSum
import com.aiweapps.bbank.extensions.retrieveServiceName
import com.aiweapps.bbank.extensions.toTransactionCashbackForm
import com.aiweapps.bbank.extensions.toTransactionHistoryItemSum
import com.aiweapps.bbank.models.TransactionHistoryModel
import com.aiweapps.bbank.models.toStr
import com.aiweapps.bbank.ui.screens.transactions.details.TransactionDetailsScreen
import com.aiweapps.bbank.utils.AppFont
import kotlin.math.abs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionHistoryItem(
    serviceModel: TransactionHistoryModel
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showBottomSheet: Boolean by remember { mutableStateOf(false) }


    Row(
        modifier = Modifier
//            .background(colorResource(id = R.color.colorAccent))
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable {
                showBottomSheet = true
            }, verticalAlignment = Alignment.CenterVertically
    ) {

        if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = colorResource(id = R.color.black),
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
                .background(Color.Transparent)
                .height(42.dp)
                .width(42.dp)
                .align(Alignment.CenterVertically)
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = serviceModel.icon),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.width(3.dp))

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Row(
                modifier = Modifier
//                    .background(Color.Yellow)
                    .fillMaxWidth()
                    .padding(top = 11.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = serviceModel.service.retrieveServiceName(),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = AppFont.Girloy,
                        fontWeight = FontWeight.Medium
                    )

                    if (serviceModel.description != "") {
                        Box(
                            modifier = Modifier
                                .padding(bottom = 0.dp, start = 8.dp)
                                .clip(shape = RoundedCornerShape(6.dp))
                                .background(colorResource(id = R.color.gray))
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                text = serviceModel.description,
                                color = colorResource(id = R.color.white),
                                fontSize = 13.sp,
                                letterSpacing = (0.1).sp,
                                fontFamily = AppFont.Girloy,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }


                }

                Text(
                    text = serviceModel.sum.toTransactionHistoryItemSum(),
                    color = serviceModel.sum.isPositiveSum(),
                    fontSize = 16.sp,
                    letterSpacing = (0.1).sp,
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.End
                )
            }

            Spacer(
                modifier = Modifier.height(6.dp)
//                .background(Color.Red)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
//                    .background(Color.Green)
                , horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = serviceModel.type.toStr(LocalContext.current),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    letterSpacing = (0.1).sp,
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight.Light
                )

                Row(verticalAlignment = Alignment.Bottom) {

                    if (serviceModel.sum < 0) {
                        val isBigCashback = abs(serviceModel.sum / 100.0) > 5.0

                        Box(
                            modifier = Modifier
                                .padding(bottom = 1.dp)
                                .clip(shape = RoundedCornerShape(4.dp))
                                .background(
                                    colorResource(
                                        id = if (isBigCashback) R.color.accent
                                        else R.color.main_gray
                                    )
                                )
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 0.dp),
                                text = serviceModel.sum.toTransactionCashbackForm(
                                    withCurrency = false,
                                    withSign = true
                                ),
                                color = colorResource(id = if (isBigCashback) R.color.black else R.color.white),
                                fontSize = 12.sp,
                                letterSpacing = (0.1).sp,
                                fontFamily = AppFont.Girloy,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Text(
                        modifier = Modifier.padding(top = 3.dp, start = 4.dp),
                        text = serviceModel.direction,
                        color = Color.Gray,
                        textAlign = TextAlign.End,
                        letterSpacing = (0.1).sp,
                        fontSize = 12.sp,
                        fontFamily = AppFont.Girloy,
                        fontWeight = FontWeight.Light
                    )
                }
            }

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(12.dp)
//                    .clip(shape = RoundedCornerShape(2.dp))
//                    .background(color)
//            )

            Spacer(
                modifier = Modifier.height(6.dp)
//                .background(Color.Blue)
            )
        }
    }
}