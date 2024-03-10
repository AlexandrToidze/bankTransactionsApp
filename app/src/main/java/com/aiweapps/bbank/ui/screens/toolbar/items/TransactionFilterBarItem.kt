package com.aiweapps.bbank.ui.screens.toolbar.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiweapps.bbank.R
import com.aiweapps.bbank.utils.AppFont

@Composable
fun transactionFilterBarItem(text: String, onClick: (() -> Unit), itemPadding: Int) {
    Row(
        modifier = Modifier
            .padding(start = itemPadding.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.main_gray))
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(0.dp, 5.dp)
            ) {
            Text(
                modifier = Modifier
//                    .background(colorResource(id = R.color.colorAccent))
                    .padding(8.dp, 0.dp, 1.dp, 0.dp),
                fontFamily = AppFont.Girloy,
                color = colorResource(id = R.color.gray),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                text = text
            )
            Icon(
                modifier = Modifier
//                    .background(Color.Red)
                    .padding(end = 8.dp)
                    .height(14.dp)
                    .width(14.dp),
                tint = colorResource(id = R.color.gray),
                imageVector = Icons.Default.Close, contentDescription = null
            )
        }
    }
}