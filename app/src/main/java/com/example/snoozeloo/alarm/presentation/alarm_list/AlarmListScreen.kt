package com.example.snoozeloo.alarm.presentation.alarm_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.example.snoozeloo.R
import com.example.snoozeloo.alarm.presentation.alarm_list.components.AlarmListItem
import com.example.snoozeloo.alarm.presentation.alarm_list.components.previewAlarmUi
import com.example.snoozeloo.ui.theme.LocalSpacing
import com.example.snoozeloo.ui.theme.SnoozelooTheme

@Composable
fun AlarmListScreen(
    modifier: Modifier = Modifier,
    state: AlarmListState
) {
    val spacing = LocalSpacing.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium),
                text = stringResource(R.string.alarms_screen_title),
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
            ) {
                items(state.alarms) { alarmUi ->
                    AlarmListItem(alarmUi = alarmUi) {

                    }

                }
            }
        }
    }

}

@Preview
@PreviewLightDark
@Composable
private fun AlarmListScreenPreview() {
    SnoozelooTheme {
        AlarmListScreen(
            state = AlarmListState(
                alarms = (1..10).map {
                    previewAlarmUi.copy(id = it.toString())
                }
            )
        )
    }
}