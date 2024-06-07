package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.fundsTabPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText

@Composable
fun FundsTabPage(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
            .background(Color.Red)
    ) {
        ExziText(text = "Funds Tab Page", size = 30.sp, color = Color.White)
    }
}