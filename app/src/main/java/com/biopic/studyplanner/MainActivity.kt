package com.biopic.studyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biopic.studyplanner.ui.theme.StudyPlannerTheme
import com.biopic.studyplanner.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyPlannerTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) { MainPage() }
            }
        }
    }
}

@Composable
fun MainPage() {
    val navController = rememberNavController()

    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Screen.ONBOARDING
    ) {
        composable(route = Screen.ONBOARDING) {
            OnBoardingScreen(
                navController = navController
            )
        }
    }
}