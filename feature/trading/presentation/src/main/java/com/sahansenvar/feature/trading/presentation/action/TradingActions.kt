package com.sahansenvar.feature.trading.presentation.action

sealed interface TradingActions {
    data object GetOrderBook : TradingActions
    data object GetCandlesData : TradingActions
    data class PasteValueToAmountTextField(val value: String) : TradingActions
    data class NavigateToChartScreen(val title: String) : TradingActions
}