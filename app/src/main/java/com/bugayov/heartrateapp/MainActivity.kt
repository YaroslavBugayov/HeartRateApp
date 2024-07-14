package com.bugayov.heartrateapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bugayov.heartrateapp.ui.App
import com.bugayov.heartrateapp.ui.components.Circle
import com.bugayov.heartrateapp.ui.navHosts.ScreenNavHost
import com.bugayov.heartrateapp.ui.screens.OnboardingScreen
import com.bugayov.heartrateapp.ui.theme.HeartRateAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}