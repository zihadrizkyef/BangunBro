package com.zr.bangunbro

import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zr.bangunbro.ui.theme.BangunBroTheme

class AlarmFiredActivity : ComponentActivity() {
    private lateinit var ringtone: Ringtone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BangunBroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(innerPadding) {
                        ringtone.stop()
                        finish()
                    }
                }
            }
        }

        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        ringtone = RingtoneManager.getRingtone(this, alarmSound)
        ringtone.play()
    }

    @Composable
    fun MainScreen(
        innerPadding: PaddingValues,
        onStopAlarm: () -> Unit,
    ) {
        Column(modifier = Modifier.padding(innerPadding)) {
            Button(
                onClick = {
                    onStopAlarm()
                }
            ) {
                Text("Stop alarm")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        BangunBroTheme {
            MainScreen(PaddingValues(), { })
        }
    }

}