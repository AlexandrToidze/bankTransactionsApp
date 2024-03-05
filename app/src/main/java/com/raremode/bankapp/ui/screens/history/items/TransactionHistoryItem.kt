package com.raremode.bankapp.ui.screens.history.items

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
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.raremode.bankapp.R
import com.raremode.bankapp.extensions.isPositiveSum
import com.raremode.bankapp.extensions.retrieveServiceName
import com.raremode.bankapp.extensions.toCashbackBoxForm
import com.raremode.bankapp.extensions.toTransactionHistoryItemSum
import com.raremode.bankapp.models.TransactionHistoryModel
import com.raremode.bankapp.models.toStr
import com.raremode.bankapp.ui.screens.details.TransactionDetailsScreen
import com.raremode.bankapp.utils.AppFont
import com.raremode.bankapp.utils.Constants
import java.util.Currency
import java.util.Locale
import kotlin.math.abs

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TransactionHistoryItem(
    serviceModel: TransactionHistoryModel,
    color: Color = Color.Gray,
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showBottomSheet: Boolean by remember { mutableStateOf(false) }


    Row(
        modifier = Modifier
//            .background(colorResource(id = R.color.colorAccent))
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 4.dp, bottom = 4.dp)
            .clickable {
                showBottomSheet = true
            },
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = colorResource(id = R.color.colorBlack),
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
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = serviceModel.icon),
                contentDescription = null
            )

//            GlideImage(
//                model = "${Constants.GLIDE_ICONS_LOAD_URL}${serviceModel.service}",
//                contentDescription = "null",
//                contentScale = ContentScale.Crop
//            )

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 9.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = serviceModel.service.retrieveServiceName(),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight.Medium
                )

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

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = serviceModel.type.toStr(),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    letterSpacing = TextUnit(2F, TextUnitType(1L)),
                    fontFamily = AppFont.Girloy,
                    fontWeight = FontWeight.Light
                )

                Row(verticalAlignment = Alignment.Bottom) {

                    if (serviceModel.sum < 0) {
                        Box(
                            modifier = Modifier
                                .padding(bottom = 1.dp)
                                .clip(shape = RoundedCornerShape(4.dp))
                                .background(colorResource(id = R.color.colorMainGray))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp, vertical = 0.dp),
                                text = serviceModel.sum.toCashbackBoxForm(),
                                color = colorResource(id = R.color.colorWhite),
                                fontSize = 12.sp,
                                letterSpacing = (0.1).sp,
                                fontFamily = AppFont.Girloy,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Text(
                        modifier = Modifier
                            .padding(top = 3.dp, start = 4.dp),
                        text = serviceModel.sumSubtitle,
                        color = Color.Gray,
                        textAlign = TextAlign.End,
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

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}