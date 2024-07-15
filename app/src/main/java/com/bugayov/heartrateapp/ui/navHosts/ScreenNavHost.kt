package com.bugayov.heartrateapp.ui.navHosts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes
import com.bugayov.heartrateapp.ui.screens.Homepage1Screen
import com.bugayov.heartrateapp.ui.screens.Homepage2Screen
import com.bugayov.heartrateapp.ui.screens.LoadingScreen
import com.bugayov.heartrateapp.ui.screens.OnboardingScreen

@Composable
fun ScreenNavHost(modifier: Modifier, screenNavController: NavHostController) {
    NavHost(
        navController = screenNavController,
        startDestination = ScreenRoutes.HOMEPAGE2,
        modifier = modifier
    ) {
        composable(ScreenRoutes.LOADING) { LoadingScreen(screenNavController) }
        composable(ScreenRoutes.ONBOARDING) { OnboardingScreen(screenNavController) }
        composable(ScreenRoutes.HOMEPAGE1) { Homepage1Screen(screenNavController) }
        composable(ScreenRoutes.HOMEPAGE2) { Homepage2Screen(screenNavController) }
    }
}