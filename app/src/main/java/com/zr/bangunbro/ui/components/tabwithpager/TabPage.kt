package com.zr.bangunbro.ui.components.tabwithpager

import androidx.compose.runtime.Composable

data class TabPage(
    val title: String,
    val screen: @Composable () -> Unit,
)