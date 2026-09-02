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
            OnboardingScreen(
                navController = navController
            )
        }

        composable(
            route = "${Screen.MAIN_SCREEN}/{name}/{goal}/{session}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("goal") {
                    type = NavType.StringType
                },
                navArgument("session") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val goal = backStackEntry.arguments?.getString("goal")
            val session = backStackEntry.arguments?.getString("session")

            name?.let { name ->
                goal?.let { goal ->
                    session?.let { session ->
                        MainScreen(navController = navController, name = name, goal = goal, session = session)
                    }
                }
            }
        }

        composable(route = Screen.ADD_SESSION_SCREEN) {  }
    }
}