package com.bugayov.heartrateapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bugayov.heartrateapp.ui.theme.LightRed
import com.bugayov.heartrateapp.ui.theme.Red
import com.bugayov.heartrateapp.ui.theme.RubikFontFamily

@Composable
fun ProgressIndicator(progress: MutableState<Int>, modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
                .clip(CircleShape),
            color = Red,
            trackColor = LightRed,
            progress = progress.value.toFloat() / 100
        )
        Text(
            text = "${progress.value}%",
            fontSize = 14.sp,
            color = Color.White,
            fontFamily = RubikFontFamily,
        )
    }
}