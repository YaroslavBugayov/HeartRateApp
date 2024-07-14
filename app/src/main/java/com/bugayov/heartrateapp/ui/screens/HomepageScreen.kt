package com.bugayov.heartrateapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.bugayov.heartrateapp.ui.components.TopBar

@Composable
fun HomepageScreen(screenNavController: NavHostController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBar(Modifier) {  }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomepageScreenPreview() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBar(Modifier) {

        }
    }
}