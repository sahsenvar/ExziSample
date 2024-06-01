package com.sahansenvar.feature.trading.presentation.screens.tradingTabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun SpotTabContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        content = { Text(text = "SPOT TAB SCREEN", color = Color.White, fontSize = 30.sp) }
    )
}

@Composable
fun MarginTabContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        content = { Text(text = "MARGIN TAB SCREEN", color = Color.White, fontSize = 30.sp) }
    )
}

@Composable
fun ConvertTabContent(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        content = { Text(text = "CONVERT TAB SCREEN", color = Color.White, fontSize = 30.sp) }
    )
}

enum class TradingTabItem(val title: String, val content: @Composable () -> Unit) {
    Spot(title = "Spot", content = { SpotTabContent() }),
    Margin(title = "Margin", content = { MarginTabContent() }),
    Convert(title = "Convert", content = { ConvertTabContent() })
}