package com.bugayov.heartrateapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavHostController
import com.bugayov.heartrateapp.R
import com.bugayov.heartrateapp.ui.components.TopBar
import com.bugayov.heartrateapp.ui.components.TopBarHistoryButton
import com.bugayov.heartrateapp.ui.components.TopBarText
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes
import com.bugayov.heartrateapp.ui.theme.RubikFontFamily

@Composable
fun Homepage1Screen(screenNavController: NavHostController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBar(Modifier) {
            Spacer(Modifier.weight(1F, true))
            TopBarText("Історія")
            TopBarHistoryButton(screenNavController)
        }
        Text(
            text = "Виконайте своє перше вимірювання!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = RubikFontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(id = R.drawable.heart_loading),
            contentDescription = "heart loading",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 40.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.weight(1F, true))
        Image(
            painter = painterResource(id = R.drawable.button_heart_rate),
            contentDescription = "button heart rate",
            Modifier.height(114.dp).width(114.dp).clickable {
                screenNavController.navigate(ScreenRoutes.HOMEPAGE2)
            }
        )
    }
}