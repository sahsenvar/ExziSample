package com.sahansenvar.feature.trading.presentation.viewModels

import androidx.lifecycle.viewModelScope
import com.sahansenvar.core.common.basesAndMarkers.BaseViewModel
import com.sahansenvar.core.common.response.onFailure
import com.sahansenvar.core.common.response.onLoading
import com.sahansenvar.core.common.response.onSuccess
import com.sahansenvar.feature.trading.domain.usecases.GetOrderBookUseCase
import com.sahansenvar.feature.trading.presentation.uiStates.OrderBookUiState
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class OrderBookViewModel(
    private val getOrderBook: GetOrderBookUseCase
) : BaseViewModel<OrderBookUiState>(OrderBookUiState()) {

    fun getOrderBook() = viewModelScope.launch {
        getOrderBook {
            onLoading {
                android.util.Log.i("exziInfo", "loading...")
                // ....
            }
            onSuccess { result ->
                android.util.Log.i("exziInfo", "network result:  $result")
                _state.value = _state.value.copy(orderBook = result)
            }
            onFailure {
                android.util.Log.i("exziInfo", "network error: $it")
                // ....
            }
        }
    }
}