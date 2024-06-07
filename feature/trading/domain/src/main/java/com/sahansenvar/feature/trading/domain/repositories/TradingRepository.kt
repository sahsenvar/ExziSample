package com.sahansenvar.feature.trading.domain.repositories

import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.domain.models.CandleDomain

interface TradingRepository {
    suspend fun getCandles(
        tradingUnits: String,
        r: Char,
        limit: Int,
        end: Int
    ): List<CandleDomain>

    suspend fun getOrderBook(
        pairId: Int,
        buy: Int,
        sell: Int
    ): OrderBookDomain

}