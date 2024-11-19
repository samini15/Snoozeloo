package com.example.snoozeloo.alarm.presentation.alarm_list

import com.example.snoozeloo.alarm.presentation.alarm_list.model.AlarmUi

sealed interface AlarmListAction {
    data class OnAlarmClick(val alarmUi: AlarmUi): AlarmListAction
}