package com.example.snoozeloo.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.snoozeloo.alarm.presentation.alarm_list.AlarmListScreen
import com.example.snoozeloo.alarm.presentation.alarm_list.AlarmListState
import com.example.snoozeloo.alarm.presentation.alarm_list.AlarmListViewModel
import com.example.snoozeloo.alarm.presentation.alarm_list.components.SnoozelooFAB
import com.example.snoozeloo.alarm.presentation.alarm_list.components.previewAlarmUi
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Route.ALARM) {
        alarmGraph(navController)
    }
}

private fun NavGraphBuilder.alarmGraph(navController: NavHostController) {
    navigation(startDestination = Route.ALARM_LIST_SCREEN, route = Route.ALARM) {
        composable(route = Route.ALARM_LIST_SCREEN) {
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

