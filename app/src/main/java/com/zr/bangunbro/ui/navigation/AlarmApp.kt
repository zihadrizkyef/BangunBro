package com.zr.bangunbro.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zr.bangunbro.ui.create_alarm.CreateAlarmScreen
import com.zr.bangunbro.ui.detail_alarm.DetailAlarmScreen
import com.zr.bangunbro.ui.home.HomeScreen

@Composable
fun AlarmApp() {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigationToDetail = { alarmId ->
                    navController.navigate(Screen.DetailAlarm.createRoute(alarmId))
                },
                onNavigationToAdd = {
                    navController.navigate(Screen.CreateAlarm.route)
                }
            )
        }
        composable(Screen.CreateAlarm.route) {
            CreateAlarmScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(
            route = Screen.DetailAlarm.route,
            arguments = listOf(navArgument(ArgumentKey.ALARM_ID) { type = NavType.LongType })
        ) { backStackEntry ->
            val alarmId = backStackEntry.arguments?.getLong(ArgumentKey.ALARM_ID) ?: 0
            DetailAlarmScreen(
                alarmId = alarmId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}