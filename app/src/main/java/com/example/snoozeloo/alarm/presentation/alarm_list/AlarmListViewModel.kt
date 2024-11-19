package com.example.snoozeloo.alarm.presentation.alarm_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class AlarmListViewModel: ViewModel() {

    private val _state = MutableStateFlow(AlarmListState())
    val state = _state
        //.onStart { loadAlarms() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L), AlarmListState()
        )

    fun onAction(action: AlarmListAction) {
        when(action) {
            is AlarmListAction.OnAlarmClick -> {
                _state.update {
                    it.copy(selectedAlarm = action.alarmUi)
                }
            }
        }
    }
}