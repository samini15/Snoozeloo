package com.example.snoozeloo.alarm.presentation.alarm_list.model

data class AlarmUi(
    val id: String,
    val title: String?,
    val hour: Int,
    val minute: Int,
    val isAm: Boolean,
    var isOn: Boolean,
    val nextOccurrence: String
)
