package com.sahansenvar.feature.trading.presentation.viewModels

import androidx.lifecycle.viewModelScope
import com.sahansenvar.core.common.basesAndMarkers.BaseViewModel
import com.sahansenvar.core.common.response.componentState
import com.sahansenvar.core.common.response.onSuccess
import com.sahansenvar.feature.trading.domain.usecases.GetCandleInfoUseCase
import com.sahansenvar.feature.trading.presentation.uiStates.TradingState
import kotlinx.coroutines.flow.launchIn
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class TradingViewModel(
    private val getCandleInfo: GetCandleInfoUseCase
) : BaseViewModel<TradingState>(TradingState()) {

    fun getCandles(
        tradingUnit: String,
        limit: Int,
        end: Int
    ) = getCandleInfo(tradingUnit, limit, end) {
         componentState
        onSuccess { result ->
            //_state.value = state.value.copy(tradingList = ComponentState.Success())
        }

    }.launchIn(viewModelScope)


}
