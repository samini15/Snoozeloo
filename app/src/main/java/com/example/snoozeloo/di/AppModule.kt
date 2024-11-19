package com.example.snoozeloo.di

import com.example.snoozeloo.alarm.presentation.alarm_list.AlarmListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::AlarmListViewModel)
}