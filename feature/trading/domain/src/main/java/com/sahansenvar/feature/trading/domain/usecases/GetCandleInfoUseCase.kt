package com.sahansenvar.feature.trading.domain.usecases

import com.sahansenvar.core.common.basesAndMarkers.BaseUseCase
import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.feature.trading.domain.models.TradingDomain
import com.sahansenvar.feature.trading.domain.repositories.TradingRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import org.koin.core.annotation.Factory

@Factory([GetCandleInfoUseCase::class])
class GetCandleInfoUseCase(
    private val tradingRepository: TradingRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase(dispatcher) {

    operator fun invoke(
        tradingUnit: String,
        limit: Int,
        end: Int,
        onEach: suspend AppResponse<List<TradingDomain>, NetworkError>.() -> Unit
    ) = runAsyncUseCase { tradingRepository.getCandles(tradingUnit, 'D', limit, end) }
        .onEach(onEach)
        .catch {
            AppResponse.Failure(NetworkError.UnknownError(it.message ?: "Unknown Error")).onEach()
        }
}