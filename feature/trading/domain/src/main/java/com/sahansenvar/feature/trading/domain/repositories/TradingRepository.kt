package com.sahansenvar.feature.trading.domain.repositories

import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.feature.trading.domain.models.TradingDomain

interface TradingRepository {
    suspend fun getCandles(
        tradingUnits: String,
        r: Char,
        limit: Int,
        end: Int
    ): AppResponse<List<TradingDomain>, NetworkError>
}