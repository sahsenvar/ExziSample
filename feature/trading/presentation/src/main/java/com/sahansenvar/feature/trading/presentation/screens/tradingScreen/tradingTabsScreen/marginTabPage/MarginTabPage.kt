package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.marginTabPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MarginTabPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta),
        content = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "MARGIN TAB SCREEN",
                color = Color.White,
                fontSize = 30.sp
            )
        }
    )
}


@Preview
@Composable
fun Preview() {
    MarginTabPage()
}