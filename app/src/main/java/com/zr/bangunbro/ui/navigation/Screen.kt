package com.zr.bangunbro.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object CreateAlarm : Screen("create-alarm")
    object DetailAlarm : Screen("detail-alarm/{alarmId}") {
        fun createRoute(alarmId: Long) = "detail-alarm/$alarmId"
    }
}