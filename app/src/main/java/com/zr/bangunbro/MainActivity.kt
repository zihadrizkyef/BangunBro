package com.zr.bangunbro

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.zr.bangunbro.di.appModule
import com.zr.bangunbro.di.useCaseModule
import com.zr.bangunbro.di.viewModelModule
import com.zr.bangunbro.ui.alarm_list.AlarmListScreen
import com.zr.bangunbro.ui.tabwithpager.TabPage
import com.zr.bangunbro.ui.tabwithpager.TabWithPager
import com.zr.bangunbro.ui.theme.BangunBroTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication
import java.time.LocalDateTime
import java.time.ZoneId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BangunBroTheme {
                val tabList = listOf(
                    TabPage("Alarm", { AlarmListScreen({}) }),
                    TabPage("Jam", {}),
                    TabPage("Stopwatch", {}),
                )
                TabWithPager(tabList)
            }
        }

        if (!Settings.canDrawOverlays(this)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                ("package:$packageName").toUri()
            )
            startActivity(intent)
        }
    }

    private fun setAlarm(): Boolean {
        val now = LocalDateTime.now()
        val next = now.plusSeconds(10L)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val canSchedule = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            alarmManager.canScheduleExactAlarms()
        } else {
            true
        }
        if (canSchedule) {
            val intent = Intent(this, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            val alarmInfo = AlarmManager.AlarmClockInfo(
                next.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(),
                pendingIntent,
            )
            alarmManager.setAlarmClock(
                alarmInfo,
                pendingIntent,
            )
        } else {
            val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
            intent.data = "package:$packageName".toUri()
            startActivity(intent)
        }
        return canSchedule
    }

    @Composable
    fun MainScreen(
        innerPadding: PaddingValues,
        onSetAlarm: () -> Boolean,
    ) {
        var canSchedule by remember { mutableStateOf<Boolean?>(null) }
        val lifecycleScope = rememberCoroutineScope()

        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Can schedule : ${canSchedule ?: ""}")
            Button(
                enabled = canSchedule == null,
                onClick = {
                    canSchedule = onSetAlarm()
                    lifecycleScope.launch {
                        delay(10_000)
                        canSchedule = null
                    }
                }
            ) {
                Text("Set Alarm for next 10 seconds")
            }
        }
    }

    @Preview(
        showBackground = true,
        device = Devices.NEXUS_7,
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    @Composable
    fun MainScreenPreview() {
        val context = LocalContext.current
        KoinApplication(application = {
            androidContext(context.applicationContext)
            modules(
                appModule,
                useCaseModule,
                viewModelModule,
            )
        }) {
            BangunBroTheme {
                val tabList = listOf(
                    TabPage("Alarm", { AlarmListScreen({}) }),
                    TabPage("Jam", {}),
                    TabPage("Stopwatch", {}),
                )
                TabWithPager(tabList)
            }
        }
    }
}