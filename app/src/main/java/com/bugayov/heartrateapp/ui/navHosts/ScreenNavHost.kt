package com.bugayov.heartrateapp.ui.navHosts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes
import com.bugayov.heartrateapp.ui.screens.LoadingScreen
import com.bugayov.heartrateapp.ui.screens.OnboardingScreen

@Composable
fun ScreenNavHost(modifier: Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.LOADING,
        modifier = modifier
    ) {
        composable(ScreenRoutes.LOADING) { LoadingScreen(navController) }
        composable(ScreenRoutes.ONBOARDING) { OnboardingScreen() }
    }
}