package com.example.snoozeloo.alarm.presentation.alarm_list

import androidx.compose.runtime.Immutable
import com.example.snoozeloo.alarm.presentation.alarm_list.model.AlarmUi

@Immutable
data class AlarmListState(
    val alarms: List<AlarmUi> = emptyList(),
    val isLoading: Boolean = false,
    val selectedAlarm: AlarmUi? = null,
    val error: String? = null

)
