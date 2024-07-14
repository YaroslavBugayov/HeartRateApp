package com.bugayov.heartrateapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bugayov.heartrateapp.ui.theme.LightBlue

@Composable
fun Circle() {
    Box(
        modifier = Modifier.fillMaxSize().padding(bottom = 200.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.size(100.dp),
            onDraw = {
                drawCircle(color = LightBlue, radius = 1000F, center = center)
            }
        )
    }
}