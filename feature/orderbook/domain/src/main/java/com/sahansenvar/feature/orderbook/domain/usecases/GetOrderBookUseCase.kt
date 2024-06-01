package com.sahansenvar.feature.orderbook.domain.usecases

import androidx.annotation.Keep
import com.sahansenvar.core.common.basesAndMarkers.BaseUseCase
import com.sahansenvar.feature.orderbook.data.repositories.OrderbookRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.annotation.Factory

@Factory([GetOrderBookUseCase::class])
class GetOrderBookUseCase(
    orderbookRepository: OrderbookRepository,
    dispatcher: CoroutineDispatcher
): BaseUseCase(dispatcher) {

}