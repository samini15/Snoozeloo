package com.example.snoozeloo.alarm.presentation.alarm_list.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snoozeloo.alarm.presentation.alarm_list.model.AlarmUi
import com.example.snoozeloo.ui.theme.LocalSpacing
import com.example.snoozeloo.ui.theme.SnoozelooTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmListItem(
    modifier: Modifier = Modifier,
    alarmUi: AlarmUi,
    onClick: () -> Unit
) {
    val spacing = LocalSpacing.current

    var checked by remember { mutableStateOf(true) }

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = spacing.spaceMedium),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = modifier
                .clickable(onClick = onClick)
                .padding(spacing.spaceMedium),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(spacing.spaceExtraSmall)
            ) {
                Text(
                    text = alarmUi.title.toString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal)

                Text(
                    text = alarmUi.hour.toString() + ":" + alarmUi.minute.toString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)

                Text(
                    text = alarmUi.nextOccurrence,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Thin)
            }


            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
        }
    }
}

@Preview
@PreviewLightDark
@Composable
private fun AlarmListItemPreview() {
    SnoozelooTheme {
        AlarmListItem(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surface),
            alarmUi = previewAlarmUi) {

        }
    }
}

internal val previewAlarmUi =
    AlarmUi(
        id = "0",
        title = "Wake up",
        hour = 10,
        minute = 0,
        isAm = true,
        isOn = true,
        nextOccurrence = "Alarm in 30min"
    )