package com.zr.bangunbro.ui.alarm_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun AlarmListScreen(
    onNavigationToDetail: (id: Long) -> Unit,
    onNavigationToAdd: () -> Unit,
    viewModel: AlarmListViewModel = koinViewModel(),
) {
    val alarms by viewModel.alarms.collectAsState()

    Box {
        LazyColumn {
            items(items = alarms, key = { it.id }) {
                AlarmItem(
                    alarm = it,
                    onRootClick = onNavigationToDetail,
                    onAlarmActiveSet = viewModel::setAlarmActive
                )
            }
        }

        FloatingActionButton(
            onClick = onNavigationToAdd,
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(16.dp),
            shape = CircleShape
        ) {
            Icon(
                Icons.Filled.Add,
                "Add Alarm",
            )
        }
    }
}