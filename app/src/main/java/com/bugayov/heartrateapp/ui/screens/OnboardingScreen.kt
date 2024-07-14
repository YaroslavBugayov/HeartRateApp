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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bugayov.heartrateapp.R
import com.bugayov.heartrateapp.ui.components.ScrollIndicator
import com.bugayov.heartrateapp.ui.theme.RubikFontFamily

@Composable
fun OnboardingScreen() {
    val navController = rememberNavController()
    val currentPage = remember {
        mutableStateOf(0)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OnboardingNavHost(modifier = Modifier.weight(4.5F), navController)
        Box(
            modifier = Modifier.weight(1F),
            contentAlignment = Alignment.Center
        ) {
            Column() {
                ScrollIndicator(3, listOf("Почати", "Продовжити", "Почати"), currentPage)
            }
        }
    }

    when (currentPage.value) {
        0 -> navController.navigate("onboarding1")
        1 -> navController.navigate("onboarding2")
        2 -> navController.navigate("onboarding3")
    }
}

@Composable
fun OnboardingNavHost(modifier: Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "onboarding1",
        modifier = modifier.padding(top = 100.dp)
    ) {
        composable("onboarding1") {
            Onboarding(
                R.drawable.onboarding_illustration_1,
                "Ваш трекер тиску",
                "Зазначайте, відстежуйте та аналізуйте свої показники артеріального тиску."
            )
        }
        composable("onboarding2") {
            Onboarding(
                R.drawable.onboarding_illustration_2,
                "Персоналізовані поради",
                "Програма надає дієві поради, які допоможуть вам підтримувати оптимальний рівень артеріального тиску та зменшити фактори ризику серцево-судинних захворювань."
            )
        }
        composable("onboarding3") {
            Onboarding(
                R.drawable.onboarding_illustration_3,
                "Нагадування",
                "Не відставайте від графіка контролю артеріального тиску та прийому ліків за допомогою спеціальних нагадувань."
            )
        }
    }
}

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Onboarding1ScreenPreview() {
    OnboardingScreen()
}