package com.biopic.studyplanner

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.biopic.studyplanner.ui.theme.Black
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.LightLavender
import com.biopic.studyplanner.ui.theme.PaleLavender
import com.biopic.studyplanner.ui.theme.PurpleGray
import com.biopic.studyplanner.ui.theme.White
import com.biopic.studyplanner.ui.theme.White20

@Composable
fun OnBoardingScreen(navController : NavController) {

    val focusManager = LocalFocusManager.current

    var nameText by remember { mutableStateOf("") }

    val list = listOf("1h", "2h", "3h", "4h", "5h")
    var selectedGoal by remember { mutableStateOf(list[1]) }
    val listSession = listOf("30 min", "45 min", "60 min", "90 min")
    var selectedSession by remember { mutableStateOf(listSession[1]) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = White,
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 28.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (nameText.isBlank()) PaleLavender else DarkPurple,
                        contentColor = if (nameText.isBlank()) PurpleGray else White
                    ),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {

                    }
                ) {
                    Text(
                        text = stringResource(R.string.get_started),
                        fontSize = 16.sp,
                        fontWeight = FontWeight(800)
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .pointerInput(Unit) {
                    detectTapGestures {
                        focusManager.clearFocus()
                    }
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                DarkPurple,
                                LightLavender
                            ),
                            start = Offset(0f, 0f),
                            end = Offset(100f, 1000f)
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp, 72.dp)
                            .clip(
                                shape = RoundedCornerShape(25.dp)
                            )
                            .background(color = White20)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "Star",
                            tint = White,
                            modifier = Modifier
                                .align(
                                    alignment = Alignment.Center
                                )
                                .size(48.dp, 48.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = stringResource(R.string.app_name),
                        fontSize = 28.sp,
                        fontWeight = FontWeight(900),
                        color = White
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = stringResource(R.string.sub_title),
                        color = White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
            ) {
                Text(
                    text = stringResource(R.string.your_name),
                    color = PurpleGray,
                    fontWeight = FontWeight(700),
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField (
                    value = nameText,
                    onValueChange = { nameText = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Black,
                        unfocusedTextColor = Black,

                        focusedContainerColor = White,
                        unfocusedContainerColor = White,

                        focusedIndicatorColor = DarkPurple,
                        unfocusedIndicatorColor = LightLavender,

                        cursorColor = Black
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(R.string.name_placeholder),
                            fontSize = 14.sp,
                            color = PurpleGray
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.fillMaxWidth(0.85f)
            ) {
                Text(
                    text = stringResource(R.string.study_goal),
                    color = PurpleGray,
                    fontWeight = FontWeight(700),
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    list.forEach { text ->
                        SelectionChip(plannerType = PlannerType.GOAL, selected = selectedGoal == text, text = text, onClick = { selectedGoal = text })
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.fillMaxWidth(0.85f)
            ) {
                Text(
                    text = stringResource(R.string.study_session),
                    color = PurpleGray,
                    fontWeight = FontWeight(700),
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listSession.forEach { text ->
                        SelectionChip(plannerType = PlannerType.SESSION, selected = selectedSession == text, text = text, onClick = { selectedSession = text })
                    }
                }
            }
        }
    }

}

@Preview (showBackground = true)
@Composable
fun OnBoardingPreview() {
    OnBoardingScreen(navController = rememberNavController())
}