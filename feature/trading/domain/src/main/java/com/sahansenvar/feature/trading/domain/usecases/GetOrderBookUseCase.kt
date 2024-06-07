package com.sahansenvar.feature.trading.domain.usecases

import com.sahansenvar.core.common.basesAndMarkers.BaseUseCase
import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.domain.repositories.TradingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.onEach
import org.koin.core.annotation.Factory

@Factory([GetOrderBookUseCase::class])
class GetOrderBookUseCase(
    private val repository: TradingRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase(dispatcher) {

    suspend operator fun invoke(
        onEach: suspend AppResponse<OrderBookDomain, NetworkError>.() -> Unit
    ) = runAsyncUseCase {
        repository.getOrderBook(1041, 1, 1)
    }.collect(onEach)
}