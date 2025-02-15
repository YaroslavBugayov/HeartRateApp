package com.bugayov.heartrateapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bugayov.heartrateapp.database.ResultDao
import com.bugayov.heartrateapp.ui.components.Circle
import com.bugayov.heartrateapp.ui.navHosts.ScreenNavHost
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes
import com.bugayov.heartrateapp.ui.screens.OnboardingScreen
import com.bugayov.heartrateapp.ui.theme.HeartRateAppTheme
import kotlinx.coroutines.delay

@Composable
fun App(/*dao: ResultDao*/) {
    val screenNavController = rememberNavController()

    HeartRateAppTheme {
        Circle()
        ScreenNavHost(modifier = Modifier, screenNavController = screenNavController, /*dao = dao*/)
    }
}