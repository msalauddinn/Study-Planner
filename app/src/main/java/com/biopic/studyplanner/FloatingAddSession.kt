package com.biopic.studyplanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.White

@Composable
fun FloatingAddSession() {
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