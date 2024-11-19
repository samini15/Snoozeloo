package com.example.snoozeloo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import com.example.snoozeloo.alarm.presentation.alarm_list.AlarmListScreen
import com.example.snoozeloo.alarm.presentation.alarm_list.AlarmListState
import com.example.snoozeloo.alarm.presentation.alarm_list.AlarmListViewModel
import com.example.snoozeloo.alarm.presentation.alarm_list.components.SnoozelooFAB
import com.example.snoozeloo.alarm.presentation.alarm_list.components.previewAlarmUi
import com.example.snoozeloo.ui.theme.SnoozelooTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            SnoozelooTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    floatingActionButton = {
                        SnoozelooFAB {
                            // TODO OnClick - Add Alarm
                        }
                    }
                ) { innerPadding ->
                    val viewModel = koinViewModel<AlarmListViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()

                    AlarmListScreen(modifier = Modifier.padding(innerPadding), state = AlarmListState(
                        alarms = (1..10).map {
                            previewAlarmUi.copy(id = it.toString())
                        }
                    ))
                }
            }
        }
    }
}