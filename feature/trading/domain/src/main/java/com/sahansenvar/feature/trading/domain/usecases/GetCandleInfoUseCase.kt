package com.sahansenvar.feature.trading.domain.usecases

import com.sahansenvar.core.common.basesAndMarkers.BaseUseCase
import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.feature.trading.domain.models.CandleDomain
import com.sahansenvar.feature.trading.domain.repositories.TradingRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.annotation.Factory

@Factory([GetCandleInfoUseCase::class])
class GetCandleInfoUseCase(
    private val tradingRepository: TradingRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase(dispatcher) {

    suspend operator fun invoke(
        tradingUnit: String,
        limit: Int,
        end: Int,
        onEach: suspend AppResponse<List<CandleDomain>, NetworkError>.() -> Unit
    ) = runAsyncUseCase { tradingRepository.getCandles(tradingUnit, 'D', limit, end) }
        .collect(onEach)
}