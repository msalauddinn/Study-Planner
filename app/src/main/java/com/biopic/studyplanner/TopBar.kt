package com.biopic.studyplanner

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.Black
import com.biopic.studyplanner.ui.theme.White

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