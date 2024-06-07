package com.sahansenvar.feature.trading.presentation.uiStates

import com.sahansenvar.core.common.basesAndMarkers.UiState
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.domain.models.CandleDomain

data class ChartUiState(
    val candles: List<CandleDomain> = emptyList(),
    val orderBook: OrderBookDomain = OrderBookDomain(emptyList(), emptyList())
): UiState
