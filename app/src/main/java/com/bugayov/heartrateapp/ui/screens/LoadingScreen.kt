package com.bugayov.heartrateapp.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bugayov.heartrateapp.R
import com.bugayov.heartrateapp.ui.components.Circle
import com.bugayov.heartrateapp.ui.components.ProgressIndicator
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes
import com.bugayov.heartrateapp.ui.theme.DarkRed
import com.bugayov.heartrateapp.ui.theme.LightBlue
import com.bugayov.heartrateapp.ui.theme.LightRed
import com.bugayov.heartrateapp.ui.theme.Red
import com.bugayov.heartrateapp.ui.theme.RubikFontFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoadingScreen(screenNavController: NavController) {
    val progress = remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        for (i in 0..100) {
            progress.value = i
            delay(5)
        }
        screenNavController.navigate(ScreenRoutes.ONBOARDING)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Column(
            Modifier.weight(4.5F),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.heart_loading),
                contentDescription = "heart loading",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Heart Rate",
                fontSize = 54.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 51.sp,
                fontFamily = RubikFontFamily
            )
        }
        ProgressIndicator(progress = progress, modifier = Modifier.weight(1F))
    }
}