package com.example.snoozeloo.alarm.presentation.alarm_list

import com.example.snoozeloo.alarm.presentation.alarm_list.model.AlarmUi

sealed interface AlarmListEvent {
    data class Error(val error: String): AlarmListEvent
}