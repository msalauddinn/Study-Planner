package com.biopic.studyplanner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.DarkCharcoal
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.PaleLavender
import com.biopic.studyplanner.ui.theme.PurpleGray
import com.biopic.studyplanner.ui.theme.White
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreenGreetings(
    name : String
) {
    val date = LocalDate.now()
    val time = LocalTime.now()

    val formatDate = date.format(
        DateTimeFormatter.ofPattern("EEEE, MMMM, d")
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f)
        ) {
            Text(
                text = formatDate,
                color = PurpleGray,
                fontWeight = FontWeight(600),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = when(time.hour) {
                    in 5..11 -> "Good morning, $name 👋"
                    in 12..16 -> "Good afternoon, $name 👋"
                    in 17..20 -> "Good evening, $name 👋"
                    else -> "Good night, $name 👋"
                },
                fontSize = 22.sp,
                fontWeight = FontWeight(900),
                color = DarkCharcoal
            )
        }

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(shape = RoundedCornerShape(100))
                .background(color = PaleLavender)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.check_circle),
                    contentDescription = "Check Circle",
                    tint = DarkPurple,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}