package com.sahansenvar.feature.trading.presentation.viewModels

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.sahansenvar.core.common.basesAndMarkers.BaseViewModel
import com.sahansenvar.core.common.response.onFailure
import com.sahansenvar.core.common.response.onLoading
import com.sahansenvar.core.common.response.onSuccess
import com.sahansenvar.feature.trading.domain.usecases.GetCandleInfoUseCase
import com.sahansenvar.feature.trading.domain.usecases.GetOrderBookUseCase
import com.sahansenvar.feature.trading.presentation.uiStates.ChartUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ChartViewModel(
    private val getCandleInfo: GetCandleInfoUseCase,
    private val getOrderBook: GetOrderBookUseCase
) : BaseViewModel<ChartUiState>(ChartUiState()) {


    fun getCandleDatas(
        tradingUnit: String,
        limit: Int,
        end: Int
    ) = viewModelScope.launch {
        getCandleInfo(tradingUnit, limit, end) {
            onLoading {
                Log.i("exziInfo", "loading...")
                // ....
            }
            onSuccess { result ->
                Log.i("exziInfo", "network result:  $result")
                delay(2000L)
                _state.emit(state.value.copy(candles = result))
                //_candleData.value = result
            }
            onFailure {
                Log.i("exziInfo", "network error: $it")
                // ....
            }
        }
    }

    fun getOrderBook() = viewModelScope.launch {
        getOrderBook {
            onLoading {
                Log.i("exziInfo", "loading...")
                // ....
            }
            onSuccess { result ->
                Log.i("exziInfo", "network result:  $result")
                _state.emit(state.value.copy(orderBook = result))
            }
            onFailure {
                Log.i("exziInfo", "network error: $it")
                // ....
            }
        }
    }

}
