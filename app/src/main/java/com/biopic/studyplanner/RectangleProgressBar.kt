package com.biopic.studyplanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.PaleLavender

@Composable
fun RectangleProgressBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
    ) {
        // Background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = PaleLavender,
                    shape = RoundedCornerShape(10.dp)
                )
        )

        // Progress
        Box(
            modifier = Modifier
                .fillMaxWidth(1f/4)
                .height(8.dp)
                .background(
                    color = DarkPurple,
                    shape = RoundedCornerShape(10.dp)
                )
        )
    }
}