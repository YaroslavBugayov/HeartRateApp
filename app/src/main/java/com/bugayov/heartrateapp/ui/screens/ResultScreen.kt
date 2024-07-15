package com.bugayov.heartrateapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bugayov.heartrateapp.ui.components.RedButton
import com.bugayov.heartrateapp.ui.components.TopBar
import com.bugayov.heartrateapp.ui.components.TopBarHistoryButton
import com.bugayov.heartrateapp.ui.components.TopBarText
import com.bugayov.heartrateapp.ui.routes.ScreenRoutes

@Composable
fun ResultScreen(screenNavController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(modifier = Modifier) {
            TopBarText(text = "Результат")
            Spacer(modifier = Modifier.weight(1F, true))
            TopBarText(text = "Історія")
            TopBarHistoryButton(screenNavController)
        }
        Spacer(modifier = Modifier.weight(1F, true))

        Spacer(modifier = Modifier.weight(1F, true))
        RedButton(text = "Готово", modifier = Modifier.padding(20.dp).fillMaxWidth()) {
            screenNavController.navigate(ScreenRoutes.HOMEPAGE1)
        }
    }
}