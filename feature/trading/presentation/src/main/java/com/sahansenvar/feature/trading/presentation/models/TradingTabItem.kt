package com.sahansenvar.feature.trading.presentation.models

import androidx.compose.runtime.Composable
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.convertTabPage.ConvertTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.marginTabPage.MarginTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.SpotTabPage

enum class TradingTabItem(val title: String) {
    Spot(title = "Spot"),
    Margin(title = "Margin"),
    Convert(title = "Convert");

    companion object {
        fun fromOrdinal(no: Int) = entries.find { no == it.ordinal } ?: Spot
    }
}
