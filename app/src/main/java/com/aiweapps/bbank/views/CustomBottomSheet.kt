package com.aiweapps.bbank.views

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

enum class ExpandedType {
    HALF, FULL, COLLAPSED
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomBottomSheet() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    var expandedType: ExpandedType by remember {
        mutableStateOf(ExpandedType.COLLAPSED)
    }

    val height: Int by animateIntAsState(
        when (expandedType) {
            ExpandedType.HALF -> (screenHeight * 0.9).toInt()
            ExpandedType.FULL -> screenHeight
            ExpandedType.COLLAPSED -> 0
        }, label = ""
    )

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetElevation = 8.dp,
        sheetShape = RoundedCornerShape(
            bottomStart = 0.dp,
            bottomEnd = 0.dp,
            topStart = 12.dp,
            topEnd = 12.dp
        ),
        sheetContent = {
            var isUpdated = false
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(height.dp)
                    .pointerInput(Unit) {
                        detectVerticalDragGestures(
                            onVerticalDrag = { change, dragAmount ->
                                change.consume()
                                if (!isUpdated) {
                                    expandedType = when {
                                        dragAmount < 0 && expandedType == ExpandedType.COLLAPSED -> {
                                            ExpandedType.HALF
                                        }
                                        dragAmount < 0 && expandedType == ExpandedType.HALF -> {
                                            ExpandedType.FULL
                                        }
                                        dragAmount > 0 && expandedType == ExpandedType.FULL -> {
                                            ExpandedType.HALF
                                        }
                                        dragAmount > 0 && expandedType == ExpandedType.HALF -> {
                                            ExpandedType.COLLAPSED
                                        }
                                        else -> {
                                            ExpandedType.FULL
                                        }
                                    }
                                    isUpdated = true
                                }
                            },
                            onDragEnd = {
                                isUpdated = false
                            }
                        )
                    }
                    .background(Color.Red)
            )
        },
        sheetPeekHeight = height.dp
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black)
        )
//        sheetContent
    }
}