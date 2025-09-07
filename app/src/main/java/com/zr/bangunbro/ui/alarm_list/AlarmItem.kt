package com.zr.bangunbro.ui.alarm_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zr.bangunbro.domain.model.Alarm
import java.time.LocalTime
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun AlarmItem(
    alarm: Alarm,
    onRootClick: (id: Long) -> Unit,
    onAlarmActiveSet: (id: Long, isActive: Boolean) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onRootClick(alarm.id) }
            .padding(16.dp)
    ) {
        // Time + Title share a Row and are baseline-aligned.
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Text(
                    modifier = Modifier.alignByBaseline(),
                    text = alarm.time.toString(),
                    fontSize = 40.sp,
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = alarm.title,
                    modifier = Modifier.alignByBaseline(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = alarm.isActive,
                onCheckedChange = { onAlarmActiveSet(alarm.id, it) }
            )
        }

        Spacer(Modifier.height(4.dp))

        Row { // days
            when {
                alarm.days.size == 7 -> Text("Ring every day")
                alarm.days.isNotEmpty() -> Text(
                    alarm.days.joinToString(" ") {
                        it.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                    }
                )

                else -> Text("Ring only once")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlarmItemPreview() {
    AlarmItem(
        Alarm(
            1,
            "Bangun kerja",
            LocalTime.of(5, 3),
            listOf(),
            true
        ),
        {},
        { _, _ -> }
    )
}