package com.zr.bangunbro.ui.tabwithpager

import androidx.compose.runtime.Composable

data class TabPage(
    val title: String,
    val screen: @Composable () -> Unit,
)