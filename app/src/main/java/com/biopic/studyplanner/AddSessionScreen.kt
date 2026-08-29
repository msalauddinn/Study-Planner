package com.biopic.studyplanner

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.studyplanner.ui.theme.Black
import com.biopic.studyplanner.ui.theme.DarkCharcoal
import com.biopic.studyplanner.ui.theme.DarkPurple
import com.biopic.studyplanner.ui.theme.PaleLavender
import com.biopic.studyplanner.ui.theme.PurpleGray
import com.biopic.studyplanner.ui.theme.White
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSessionScreen() {

    var subject by remember { mutableStateOf("") }
    var topic by remember { mutableStateOf("") }

    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var showDatePicker by remember { mutableStateOf(false) }

    var selectedTime by remember { mutableStateOf(LocalTime.now()) }
    var showTimePicker by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = White,
        topBar = {
            SessionTopBar(
                title = stringResource(R.string.add_study_session)
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .background(color = PaleLavender)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.subject),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = PurpleGray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = subject,
                        onValueChange = { subject = it },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = Black,
                            unfocusedTextColor = Black,

                            focusedContainerColor = White,
                            unfocusedContainerColor = White,

                            focusedIndicatorColor = DarkPurple,
                            unfocusedIndicatorColor = DarkPurple,

                            cursorColor = Black
                        ),
                        placeholder = {
                            Text(
                                text = stringResource(R.string.subject_place_holder),
                                color = PurpleGray,
                                fontSize = 14.sp
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = stringResource(R.string.topic),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = PurpleGray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = topic,
                        onValueChange = { topic = it },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = Black,
                            unfocusedTextColor = Black,

                            focusedContainerColor = White,
                            unfocusedContainerColor = White,

                            focusedIndicatorColor = DarkPurple,
                            unfocusedIndicatorColor = DarkPurple,

                            cursorColor = Black
                        ),
                        placeholder = {
                            Text(
                                text = stringResource(R.string.topic_place_holder),
                                color = PurpleGray,
                                fontSize = 14.sp
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 60.dp)
                    ) {
                        Column(
                            modifier = Modifier.width(170.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.date),
                                fontSize = 12.sp,
                                fontWeight = FontWeight(700),
                                color = PurpleGray
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .pointerInput(Unit) {
                                        awaitPointerEventScope {
                                            while (true) {
                                                awaitFirstDown(
                                                    requireUnconsumed = false,
                                                    pass = PointerEventPass.Initial
                                                )

                                                showDatePicker = true
                                            }
                                        }
                                    }
                            ){
                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    value = selectedDate.format(
                                        DateTimeFormatter.ofPattern("dd-MM-yyyy")
                                    ),
                                    onValueChange = {  },
                                    readOnly = true,
                                    trailingIcon = {
                                        Icon(
                                            painter = painterResource(R.drawable.calendar),
                                            contentDescription = "Select Date",
                                            tint = DarkCharcoal
                                        )
                                    },
                                    shape = RoundedCornerShape(10.dp),
                                    colors = TextFieldDefaults.colors(
                                        focusedTextColor = Black,
                                        unfocusedTextColor = Black,

                                        focusedContainerColor = White,
                                        unfocusedContainerColor = White,

                                        focusedIndicatorColor = DarkPurple,
                                        unfocusedIndicatorColor = DarkPurple,

                                        cursorColor = Black
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            modifier = Modifier.width(150.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.time),
                                fontSize = 12.sp,
                                fontWeight = FontWeight(700),
                                color = PurpleGray
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .pointerInput(Unit) {
                                        awaitPointerEventScope {
                                            while (true) {
                                                awaitFirstDown(
                                                    requireUnconsumed = false,
                                                    pass = PointerEventPass.Initial
                                                )

                                                showTimePicker = true
                                            }
                                        }
                                    }
                            ){
                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    value = selectedTime.format(
                                        DateTimeFormatter.ofPattern("hh:mm a")
                                    ),
                                    onValueChange = {  },
                                    readOnly = true,
                                    trailingIcon = {
                                        Icon(
                                            painter = painterResource(R.drawable.clock),
                                            contentDescription = "Select Time",
                                            tint = DarkCharcoal
                                        )
                                    },
                                    shape = RoundedCornerShape(10.dp),
                                    colors = TextFieldDefaults.colors(
                                        focusedTextColor = Black,
                                        unfocusedTextColor = Black,

                                        focusedContainerColor = White,
                                        unfocusedContainerColor = White,

                                        focusedIndicatorColor = DarkPurple,
                                        unfocusedIndicatorColor = DarkPurple,

                                        cursorColor = Black
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    )

    val datePickerState = rememberDatePickerState()
    val timePickerState = rememberTimePickerState()

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false},
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let {
                            selectedDate = Instant
                                .ofEpochMilli(it)
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()
                        }
                        showDatePicker = false
                    }
                ) {
                    Text(
                        text = stringResource(R.string.ok)
                    )
                }
            }
        ) {
            DatePicker(
                state = datePickerState
            )
        }
    }

    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        selectedTime = LocalTime.of(
                            timePickerState.hour,
                            timePickerState.minute
                        )
                        showTimePicker = false
                    }
                ) {
                    Text(
                        text = stringResource(R.string.ok)
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(R.string.select_time),
                    fontSize = 28.sp,
                    fontWeight = FontWeight(900),
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
        ) {
            TimePicker(
                state = timePickerState
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun AddSessionScreenPreview() {
    AddSessionScreen()
}