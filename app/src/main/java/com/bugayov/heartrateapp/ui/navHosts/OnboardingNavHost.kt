package com.bugayov.heartrateapp.ui.navHosts

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bugayov.heartrateapp.R
import com.bugayov.heartrateapp.ui.components.Onboarding

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