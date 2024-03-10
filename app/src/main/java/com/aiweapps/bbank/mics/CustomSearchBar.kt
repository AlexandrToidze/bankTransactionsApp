package com.aiweapps.bbank.mics

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiweapps.bbank.R
import com.aiweapps.bbank.utils.AppFont


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    placeholder: @Composable () -> Unit = {},
    focusRequester: FocusRequester = FocusRequester(),
    onChangeQuery: ((String) -> Unit)
) {
    val interactionSource = remember { MutableInteractionSource() }
    var textFieldValueState by remember {
        mutableStateOf(
            TextFieldValue(
                text = ""
            )
        )
    }
    BasicTextField(
        value = textFieldValueState,
        onValueChange = {
            textFieldValueState = it
            onChangeQuery.invoke(it.text)
        },
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = AppFont.Girloy,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.colorGray)
        ),
        cursorBrush = SolidColor(colorResource(id = R.color.colorGray)),
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(color = colorResource(id = R.color.colorGray))
            .focusRequester(focusRequester)
    ) {
        TextFieldDefaults.DecorationBox(
            value = textFieldValueState.text,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(id = R.color.colorMainGray),
                unfocusedContainerColor = colorResource(id = R.color.colorMainGray),
                cursorColor = colorResource(id = R.color.colorGray),
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            innerTextField = it,
            enabled = true,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            // keep horizontal paddings but change the vertical
            placeholder = {
                placeholder()
            },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                    modifier = Modifier.size(20.dp),
                    contentDescription = "search icon",
                    tint = colorResource(id = R.color.colorGray)
                )
            },
            trailingIcon = {},
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = 0.dp,
                bottom = 0.dp,
                start = 0.dp, end = 0.dp
            ),
        )
    }
}