package com.bugayov.heartrateapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import com.bugayov.heartrateapp.ui.theme.Grey
import com.bugayov.heartrateapp.ui.theme.Red

@Composable
fun ScrollIndicator(pagesCount: Int, buttonText: List<String>, currentPage: MutableState<Int>) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (point in 0 until pagesCount) {
                IndicationPoint(
                    if (currentPage.value < buttonText.size) currentPage.value == point
                    else point == pagesCount - 1
                )
            }
        }

        val text: String = if (currentPage.value < buttonText.size) buttonText[currentPage.value] else "Почати"

        RedButton(text) { currentPage.value++ }
    }
}

@Composable
fun IndicationPoint(isActive: Boolean) {
    Canvas(
        modifier = Modifier.size(if (isActive) 52.dp else 22.dp, 20.dp),
        onDraw = {
            drawRoundRect(
                color = if (isActive) Red else Grey,
                size = Size(if (isActive) 44.dp.toPx() else 14.dp.toPx(), 14.dp.toPx()),
                cornerRadius = CornerRadius(14.dp.toPx(), 14.dp.toPx())
            )
        }
    )
}