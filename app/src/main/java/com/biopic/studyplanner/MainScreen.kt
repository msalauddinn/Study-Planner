package com.biopic.studyplanner

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.studyplanner.ui.theme.Black
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.PaleLavender
import com.biopic.studyplanner.ui.theme.PurpleGray
import com.biopic.studyplanner.ui.theme.White

@Composable
fun MainScreen(
    navController : NavController,
    name : String,
    goal : String,
    session : String
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
            when(screenType) {
                ScreenType.HOME -> FloatingAddSession()
                ScreenType.SESSION -> FloatingAddSession()
                else -> {}
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title : String) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White
        ),
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight(800),
                color = Black
            )
        }
    )
}

@Composable
fun NavigationIcon(
    screenType : ScreenType,
    navigationType : ScreenType,
    onClick : () -> Unit
) {
    val isSelected = screenType == navigationType
    Column(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures {
                onClick()
            }
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(62.dp, 30.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = if (isSelected) PaleLavender else Color.Transparent
            )
        ) {
            Icon(
                painter = painterResource(
                    when(navigationType) {
                        ScreenType.HOME -> if (isSelected) R.drawable.filled_home else R.drawable.home
                        ScreenType.SESSION -> if (isSelected) R.drawable.event_note else R.drawable.session
                        ScreenType.SETTINGS -> if (isSelected) R.drawable.filled_setting else R.drawable.setting
                    }
                ),
                contentDescription = "Home",
                tint = if (isSelected) DarkPurple else PurpleGray
            )
        }

        Text(
            text = when(navigationType) {
                ScreenType.HOME -> stringResource(R.string.home)
                ScreenType.SESSION -> stringResource(R.string.session)
                ScreenType.SETTINGS -> stringResource(R.string.setting)
            },
            fontSize = 12.sp,
            fontWeight = FontWeight(700),
            color = if (isSelected) DarkPurple else PurpleGray
        )
    }
}

@Composable
fun FloatingAddSession() {
    FloatingActionButton(
        modifier = Modifier.size(150.dp, 52.dp),
        shape = RoundedCornerShape(50),
        containerColor = DarkPurple,
        contentColor = White,
        onClick = {

        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.add),
                contentDescription = "Add",
                tint = White,
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = stringResource(R.string.add_session),
                fontSize = 14.sp,
                fontWeight = FontWeight(700)
            )
        }
    }
}