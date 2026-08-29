package com.biopic.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.White

@Composable
fun MainScreen(
    navController : NavController,
    name : String,
    goal : String
) {

    var screenType by remember { mutableStateOf(ScreenType.HOME) }

    Scaffold(
        containerColor = White,
        topBar = {
            when(screenType) {
                ScreenType.SESSION -> TopBar(title = stringResource(R.string.session_title))
                ScreenType.SETTINGS -> TopBar(title = stringResource(R.string.setting_title))
                else -> {  }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.size(150.dp, 52.dp),
                shape = RoundedCornerShape(50),
                containerColor = DarkPurple,
                contentColor = White,
                onClick = {

                }
            ) {
                when(screenType) {
                    ScreenType.HOME -> FloatingAddSession()
                    ScreenType.SESSION -> FloatingAddSession()
                    else -> {}
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NavigationIcon(screenType = screenType, navigationType = ScreenType.HOME, onClick = { screenType = ScreenType.HOME})
                NavigationIcon(screenType = screenType, navigationType = ScreenType.SESSION, onClick = { screenType = ScreenType.SESSION})
                NavigationIcon(screenType = screenType, navigationType = ScreenType.SETTINGS, onClick = { screenType = ScreenType.SETTINGS})
            }
        },
        content = { paddingValues ->
            if (ScreenType.HOME == screenType) HomeScreen(paddingValues = paddingValues, name = name, goal = goal)
        }
    )
}