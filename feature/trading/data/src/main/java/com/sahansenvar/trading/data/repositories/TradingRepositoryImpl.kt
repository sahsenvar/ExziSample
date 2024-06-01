package com.sahansenvar.trading.data.repositories

import com.sahansenvar.core.common.response.map
import com.sahansenvar.trading.data.datasource.TradingRemoteSource
import com.sahansenvar.feature.trading.domain.repositories.TradingRepository
import com.sahansenvar.trading.data.mappers.TradingMapper
import org.koin.core.annotation.Factory

@Factory
class TradingRepositoryImpl(
    private val tradingRemoteSource: TradingRemoteSource,
    private val tradingMapper: TradingMapper
) : TradingRepository {

    override suspend fun getCandles(
        tradingUnits: String,
        r: Char,
        limit: Int,
        end: Int
    ) = tradingRemoteSource.getCandles(tradingUnits, r, limit, end)
        .map { tradingMapper.mapToDomain(it) }

}
