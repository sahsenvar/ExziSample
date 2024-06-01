package com.sahansenvar.feature.orderbook.presentation.viewModels

import com.sahansenvar.core.common.basesAndMarkers.BaseViewModel
import com.sahansenvar.feature.trading.presentation.uiStates.OrderBookState
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class OrderBookViewModel(

): BaseViewModel<OrderBookState>(OrderBookState()) {

}