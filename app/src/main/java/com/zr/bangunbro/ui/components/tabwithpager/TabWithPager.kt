package com.zr.bangunbro.ui.components.tabwithpager

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zr.bangunbro.di.appModule
import com.zr.bangunbro.di.useCaseModule
import com.zr.bangunbro.di.viewModelModule
import com.zr.bangunbro.ui.alarm_list.AlarmListScreen
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

@Composable
fun TabWithPager(tabList: List<TabPage>) {
    val pagerState = rememberPagerState(pageCount = { tabList.size })
    val coroutineScope = rememberCoroutineScope()

    Scaffold { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
            ) {
                tabList.forEachIndexed { index, tab ->
                    Tab(
                        modifier = Modifier.wrapContentSize(),
                        isSelected = pagerState.currentPage == index,
                        title = tab.title,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                    )
                }
            }

            HorizontalPager(
                pagerState,
                Modifier.fillMaxSize(),
            ) { page ->
                tabList[page].screen()
            }
        }
    }
}

@Composable
fun Tab(
    isSelected: Boolean,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier.clickable(
            onClick = onClick
        )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .wrapContentHeight(Alignment.CenterVertically),
            text = title,
            textAlign = TextAlign.Center,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.NEXUS_7,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun TabWithPagerPreview() {
    val context = LocalContext.current
    KoinApplication(application = {
        androidContext(context.applicationContext)
        modules(appModule, useCaseModule, viewModelModule)
    }) {
        val tabList = listOf(
            TabPage("Alarm", { AlarmListScreen({}, {}) }),
            TabPage("Jam", {}),
            TabPage("Stopwatch", {}),
            TabPage("Pengatur Waktu", {}),
        )
        TabWithPager(tabList)
    }
}