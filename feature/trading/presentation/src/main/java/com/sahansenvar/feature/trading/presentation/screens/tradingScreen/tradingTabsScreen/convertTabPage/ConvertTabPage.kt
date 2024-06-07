package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.convertTabPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ConvertTabPage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        content = {
            Text(
                modifier = modifier.fillMaxSize(),
                text = "CONVERT TAB SCREEN",
                color = Color.White,
                fontSize = 30.sp
            )
        }
    )
}



@Preview
@Composable
fun Preview(){
    ConvertTabPage()
}