package com.sahansenvar.feature.trading.presentation.uiStates

import androidx.annotation.Keep
import com.sahansenvar.core.common.basesAndMarkers.UiState
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.domain.models.TradingDomain
import com.sahansenvar.feature.trading.presentation.models.TradingTabItem

@Keep
data class TradingUiState(
    var candles: List<TradingDomain> = emptyList(),
    val orderBook: OrderBookDomain = OrderBookDomain(emptyList(), emptyList())
): UiState