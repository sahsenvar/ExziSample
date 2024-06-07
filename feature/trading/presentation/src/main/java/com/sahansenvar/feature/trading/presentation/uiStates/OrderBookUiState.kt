package com.sahansenvar.feature.trading.presentation.uiStates

import androidx.annotation.Keep
import com.sahansenvar.core.common.basesAndMarkers.UiState
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain

@Keep
data class OrderBookUiState(
    val orderBook: OrderBookDomain = OrderBookDomain(emptyList(), emptyList())
): UiState