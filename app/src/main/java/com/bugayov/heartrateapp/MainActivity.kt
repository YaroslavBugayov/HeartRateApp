package com.bugayov.heartrateapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bugayov.heartrateapp.database.ResultsDatabase
import com.bugayov.heartrateapp.ui.App
import com.bugayov.heartrateapp.ui.components.Circle
import com.bugayov.heartrateapp.ui.navHosts.ScreenNavHost
import com.bugayov.heartrateapp.ui.screens.OnboardingScreen
import com.bugayov.heartrateapp.ui.theme.HeartRateAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val db = ResultsDatabase.getDatabase(this@MainActivity)
//                val dao = db.resultDao()
//
//                setContent {
//                    App(dao)
//                }
//            } catch (e: IOException) {}
//        }

        setContent {
            App(/*dao*/)
        }

    }
}