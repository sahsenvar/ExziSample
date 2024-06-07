package com.sahansenvar.trading.data.repositories

import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.core.common.response.map
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.trading.data.datasource.TradingRemoteSource
import com.sahansenvar.feature.trading.domain.repositories.TradingRepository
import com.sahansenvar.trading.data.datasource.OrderBookRemoteSource
import com.sahansenvar.trading.data.mappers.OrderBookMapper
import com.sahansenvar.trading.data.mappers.TradingMapper
import com.sahansenvar.trading.data.models.OrderBookData
import org.koin.core.annotation.Factory
import retrofit2.await

@Factory
class TradingRepositoryImpl(
    private val tradingRemoteSource: TradingRemoteSource,
    private val orderBookRemoteSource: OrderBookRemoteSource,
    private val tradingMapper: TradingMapper,
    private val orderBookMapper: OrderBookMapper
) : TradingRepository {

    override suspend fun getCandles(
        tradingUnits: String,
        r: Char,
        limit: Int,
        end: Int
    ) = tradingRemoteSource.getCandles(tradingUnits, r, limit, end)
        .run { tradingMapper.mapToDomain(this) }

    override suspend fun getOrderBook(
        pairId: Int,
        buy: Int,
        sell: Int
    ) = orderBookRemoteSource.getOrderBookDatas(pairId, buy, sell)
        .run { orderBookMapper.mapToDomain(this) }

}
