package com.zr.bangunbro.ui.home

import androidx.compose.runtime.Composable
import com.zr.bangunbro.ui.alarm_list.AlarmListScreen
import com.zr.bangunbro.ui.components.tabwithpager.TabPage
import com.zr.bangunbro.ui.components.tabwithpager.TabWithPager

@Composable
fun HomeScreen(
    onNavigationToDetail: (Long) -> Unit,
    onNavigationToAdd: () -> Unit,
) {
    val tabList = listOf(
        TabPage("Alarm") {
            AlarmListScreen(
                onNavigationToDetail = onNavigationToDetail,
                onNavigationToAdd = onNavigationToAdd,
            )
        },
        TabPage("Jam", {}),
        TabPage("Stopwatch", {}),
    )
    TabWithPager(tabList)
}