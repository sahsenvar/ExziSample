package com.sahansenvar.feature.trading.domain.repositories

import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.domain.models.TradingDomain

interface TradingRepository {
    suspend fun getCandles(
        tradingUnits: String,
        r: Char,
        limit: Int,
        end: Int
    ): List<TradingDomain>

    suspend fun getOrderBook(
        pairId: Int,
        buy: Int,
        sell: Int
    ): OrderBookDomain

}