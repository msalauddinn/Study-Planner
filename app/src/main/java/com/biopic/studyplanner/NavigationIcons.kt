package com.biopic.studyplanner

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.PaleLavender
import com.biopic.studyplanner.ui.theme.PurpleGray

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