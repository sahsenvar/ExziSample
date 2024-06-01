package com.sahansenvar.feature.trading.presentation.uiStates

import androidx.annotation.Keep
import com.sahansenvar.core.common.basesAndMarkers.ComponentState
import com.sahansenvar.core.common.basesAndMarkers.UiState

@Keep
data class TradingState(
    var tradingList: ComponentState = ComponentState.Idle
): UiState