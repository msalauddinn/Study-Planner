package com.biopic.studyplanner

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.DarkCharcoal
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.PaleLavender
import com.biopic.studyplanner.ui.theme.PurpleGray
import com.biopic.studyplanner.ui.theme.White

@Composable
fun ProgressBar(
    goal : String
) {

    val goalTime = when(goal) {
        "1h" -> 1
        "2h" -> 2
        "3h" -> 3
        "4h" -> 4
        "5h" -> 5
        else -> -1
    }

    val completedTime = 1f
    val progressPercentage = ((completedTime / goalTime) * 100).toInt()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            // Progress Text
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.today_progress),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(800),
                    color = DarkCharcoal
                )

                Column(
                    modifier = Modifier
                        .size(50.dp, 28.dp)
                        .clip(shape = RoundedCornerShape(50))
                        .background(PaleLavender),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$progressPercentage%",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = DarkPurple
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Circle Progress bar
            Row(
               modifier = Modifier
                   .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier.size(110.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(
                        modifier = Modifier.fillMaxSize(),
                        onDraw = {
                            // White Circle
                            drawCircle(
                                color = White
                            )

                            // Outlined Circle
                            drawCircle(
                                color = PaleLavender,
                                style = Stroke(width = 10.dp.toPx())
                            )

                            // Arc Progression
                            drawArc(
                                color = DarkPurple,
                                startAngle = -90f,
                                sweepAngle = (progressPercentage.toFloat() / 100) * 360f,
                                style = Stroke(
                                    width = 10.dp.toPx(),
                                    cap = StrokeCap.Round
                                ),
                                useCenter = false
                            )
                        }
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.one),
                            fontSize = 20.sp,
                            fontWeight = FontWeight(900),
                            color = DarkCharcoal
                        )

                        Text(
                            text = stringResource(R.string.of_four),
                            fontSize = 11.sp,
                            fontWeight = FontWeight(600),
                            color = PurpleGray
                        )
                    }
                }

                Spacer(modifier = Modifier.width(36.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.sessions),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            color = PurpleGray
                        )

                        Text(
                            text = "1/4",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(700),
                            color = DarkCharcoal
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    RectangleProgressBar()

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.study_time),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            color = PurpleGray
                        )

                        Text(
                            text = "${completedTime.toInt()}h/" + goal,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(700),
                            color = DarkCharcoal
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    RectangleProgressBar()
                }
            }
        }
    }

}