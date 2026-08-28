package com.biopic.studyplanner

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.PaleLavender
import com.biopic.studyplanner.ui.theme.PurpleGray

@Composable
fun SelectionChip(
    plannerType: PlannerType,
    selected : Boolean,
    text : String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .size(
                when(plannerType) {
                    PlannerType.GOAL -> 48.dp
                    PlannerType.SESSION -> 68.dp
                },
                40.dp
            )
            .clickable( onClick = onClick ),
        color = PaleLavender,
        shape = RoundedCornerShape(50),
        border = BorderStroke(width = 1.dp, color = (if (selected) DarkPurple else Color.Transparent))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                color = if (selected) DarkPurple else PurpleGray,
                fontWeight = FontWeight(if (selected) 700 else 500)
            )
        }
    }
}