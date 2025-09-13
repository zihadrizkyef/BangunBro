package com.zr.bangunbro.ui.create_alarm

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zr.bangunbro.di.appModule
import com.zr.bangunbro.di.useCaseModule
import com.zr.bangunbro.di.viewModelModule
import com.zr.bangunbro.ui.alarm_list.AlarmListScreen
import com.zr.bangunbro.ui.components.tabwithpager.TabPage
import com.zr.bangunbro.ui.components.tabwithpager.TabWithPager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAlarmScreen(
    onBack: () -> Unit,
    viewModel: CreateAlarmViewModel = koinViewModel()
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            CenterAlignedTopAppBar(
                title = { Text("Create Alarm") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.saveAlarm() }) {
                        Icon(Icons.Default.Check, contentDescription = "Save")
                    }
                }
            )


            Text(
                text = "Alarm will ring in ${viewModel.time}",
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PHONE,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun CreateAlarmPreview() {
    val context = LocalContext.current
    KoinApplication(application = {
        androidContext(context.applicationContext)
        modules(appModule, useCaseModule, viewModelModule)
    }) {
        CreateAlarmScreen({})
    }
}