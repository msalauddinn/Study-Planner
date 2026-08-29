package com.biopic.studyplanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biopic.studyplanner.ui.theme.LightLavender

@Composable
fun HomeScreen(
    paddingValues : PaddingValues,
    name : String,
    goal : String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = LightLavender)
    ) {
        HomeScreenGreetings(name = name)

        Spacer(modifier = Modifier.height(20.dp))

        ProgressBar(goal = goal)
    }
}