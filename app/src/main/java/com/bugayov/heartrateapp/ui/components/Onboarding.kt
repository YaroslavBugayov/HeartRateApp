package com.bugayov.heartrateapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bugayov.heartrateapp.ui.theme.RubikFontFamily

@Composable
fun Onboarding(image: Int, title: String, body: String) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 50.dp),
            painter = painterResource(id = image),
            contentDescription = "illustration",
            contentScale = ContentScale.Crop
        )
        Spacer(
            Modifier.height(80.dp)
        )
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 28.sp,
            fontFamily = RubikFontFamily,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Text(
            text = body,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 22.sp,
            fontFamily = RubikFontFamily,
            textAlign = TextAlign.Center
        )
    }
}