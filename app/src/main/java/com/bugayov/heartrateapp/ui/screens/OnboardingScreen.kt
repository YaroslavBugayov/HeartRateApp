package com.bugayov.heartrateapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bugayov.heartrateapp.ui.components.ScrollIndicator
import com.bugayov.heartrateapp.ui.navHosts.OnboardingNavHost
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes

@Composable
fun OnboardingScreen(screenNavController: NavHostController) {
    val onboardingNavController = rememberNavController()
    val pagesCount = 3
    val currentPage = remember { mutableStateOf(0) }

    if (currentPage.value >= pagesCount) {
        screenNavController.navigate(ScreenRoutes.HOMEPAGE1)
        currentPage.value = 0
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OnboardingNavHost(modifier = Modifier.weight(4.5F), onboardingNavController)
        Box(
            modifier = Modifier.weight(1F),
            contentAlignment = Alignment.Center
        ) {
            Column {
                ScrollIndicator(pagesCount, listOf("Почати", "Продовжити", "Почати"), currentPage)
            }
        }
    }

    when (currentPage.value) {
        0 -> onboardingNavController.navigate("onboarding1")
        1 -> onboardingNavController.navigate("onboarding2")
        2 -> onboardingNavController.navigate("onboarding3")
    }
}