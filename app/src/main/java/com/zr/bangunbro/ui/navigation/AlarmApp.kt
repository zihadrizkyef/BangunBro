package com.zr.bangunbro.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zr.bangunbro.ui.CreateAlarmScreen
import com.zr.bangunbro.ui.DetailAlarmScreen
import com.zr.bangunbro.ui.home.HomeScreen

@Composable
fun AlarmApp() {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(
                onNavigationToDetail = { alarmId ->
                    navController.navigate("detail-alarm/$alarmId")
                },
                onNavigationToAdd = {
                    navController.navigate("create-alarm")
                }
            )
        }
        composable("create-alarm") {
            CreateAlarmScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(
            route = "detail-alarm/{alarmId}",
            arguments = listOf(navArgument("alarmId") { type = NavType.LongType })
        ) { backstackEntry ->
            val alarmId = backstackEntry.arguments?.getLong("alarmId") ?: 0L
            DetailAlarmScreen(
                alarmId = alarmId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}