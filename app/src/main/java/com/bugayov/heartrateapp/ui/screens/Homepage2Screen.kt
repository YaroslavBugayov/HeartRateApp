package com.bugayov.heartrateapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bugayov.heartrateapp.R
import com.bugayov.heartrateapp.database.ResultDao
import com.bugayov.heartrateapp.database.ResultEntity
import com.bugayov.heartrateapp.ui.components.CameraView
import com.bugayov.heartrateapp.ui.components.ProgressIndicator
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes
import com.bugayov.heartrateapp.ui.theme.RubikFontFamily
import java.util.Date

@Composable
fun Homepage2Screen(screenNavController: NavHostController, /*dao: ResultDao*/) {
    val isFingerDetected = remember { mutableStateOf(false) }
    val pulseBpm = remember { mutableStateOf(0) }
    val progress = remember { mutableStateOf(0) }


    if (progress.value > 100) {
        progress.value = 0
        /*LaunchedEffect(Unit) {
            dao.insert(ResultEntity(
                id = 0,
                bpm = pulseBpm.value,
                date = Date().time
            ))
        }*/
        screenNavController.navigate(ScreenRoutes.RESULT)
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(80.dp)
        ) {
            IconButton(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = { screenNavController.navigate(ScreenRoutes.HOMEPAGE1) }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Exit",
                    tint = DarkGray,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
            }
            CameraView(
                modifier = Modifier.align(Alignment.BottomCenter),
                isFingerDetected,
                progress,
                pulseBpm
            )
        }

        Text(
            text = stringResource(
                if (isFingerDetected.value) R.string.finger_detected_top_label
                else R.string.no_finger_detected_top_label
            ),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = RubikFontFamily,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
        )
        Text(
            text = stringResource(
                if (isFingerDetected.value) R.string.finger_detected_bottom_label
                else R.string.no_finger_detected_bottom_label
            ),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = RubikFontFamily,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 60.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "heart",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (isFingerDetected.value) pulseBpm.value.toString() else "--",
                    fontSize = 62.sp,
                    lineHeight = 22.sp,
                    color = Color.White
                )
                Text(
                    text = "bpm",
                    fontSize = 22.sp,
                    lineHeight = 22.sp,
                    color = Color.White
                )
            }
        }
        if (isFingerDetected.value) {
            Spacer(modifier = Modifier.height(100.dp))
            ProgressIndicator(progress = progress, modifier = Modifier)
        } else {
            Image(
                painter = painterResource(id = R.drawable.hands_and_phone),
                contentDescription = "hands and phone",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 150.dp, end = 110.dp, top = 30.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}