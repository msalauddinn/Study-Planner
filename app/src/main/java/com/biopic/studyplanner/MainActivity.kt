package com.biopic.studyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.biopic.studyplanner.ui.theme.StudyPlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyPlannerTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) { MainScreen(navController = rememberNavController(), name = "Md Salauddin", goal = "2h") }
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

        composable(
            route = "${Screen.MAINSCREEN}/{name}/{goal}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("goal") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val goal = backStackEntry.arguments?.getString("goal")

            name?.let { name ->
                goal?.let { goal ->
                    MainScreen(navController = navController, name = name, goal = goal)
                }
            }
        }
    }
}