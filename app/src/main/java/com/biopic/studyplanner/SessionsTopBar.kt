package com.biopic.studyplanner

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.DarkCharcoal
import com.biopic.studyplanner.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionTopBar(
    title : String
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
        ),
        navigationIcon = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = "Arrow Back",
                    tint = DarkCharcoal,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight(800),
                color = DarkCharcoal
            )
        }
    )
}