package com.bugayov.heartrateapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.bugayov.heartrateapp.ui.theme.SlowPulse

@Composable
fun ResultBox() {
    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
        Column(modifier = Modifier
            .padding(10.dp)
        ) {
            Row() {
                Column() {
                    Text("Ваш результат")
                    Text("Звичайний")
                }
                Row() {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Time")
                    Column() {
                        Text("11:07")
                        Text("30/01/2024")
                    }
                }
            }
            ResultBar()
            Row() {
                Column {
                    StateText()
                    StateText()
                    StateText()
                }
                Spacer(modifier = Modifier)
                Column {
                    BpmText()
                    BpmText()
                    BpmText()
                }
            }
        }
    }
}

@Composable
fun ResultBar() {
//    Canvas(modifier = Modifier, onDraw = { result -> drawRoundRect(color = SlowPulse) })
}

@Composable
fun StateText() {

}

@Composable
fun BpmText() {

}