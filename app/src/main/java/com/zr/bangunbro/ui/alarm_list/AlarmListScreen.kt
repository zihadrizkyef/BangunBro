package com.zr.bangunbro.ui.alarm_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun AlarmListScreen(
    onNavigationToDetail: (id: Long) -> Unit,
    viewModel: AlarmListViewModel = koinViewModel(),
) {
    val alarms by viewModel.alarms.collectAsState()

    LazyColumn {
        items(items = alarms, key = { it.id }) {
            AlarmItem(
                alarm = it,
                onRootClick = onNavigationToDetail,
                onAlarmActiveSet = viewModel::setAlarmActive
            )
        }
    }
}