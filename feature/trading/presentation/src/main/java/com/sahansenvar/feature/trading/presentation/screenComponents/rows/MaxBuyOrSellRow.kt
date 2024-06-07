package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun MaxBuyOrSellRow(
    modifier: Modifier = Modifier,
    buyOrSellPosition: BuyOrSellPosition,
    maxValue: Float,
    unit: CurrencyUnit
) {
    Box(modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            ExziText(text = "Max. ${buyOrSellPosition.name}", size = 11.sp)
            ExziText(text = "${maxValue.toString().format("%.2f")} $unit", size = 11.sp)
        }
    }
}