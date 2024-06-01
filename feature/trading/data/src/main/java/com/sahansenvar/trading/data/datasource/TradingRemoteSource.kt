package com.sahansenvar.trading.data.datasource

import com.sahansenvar.core.common.basesAndMarkers.RemoteSource
import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.trading.data.models.TradingData
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface TradingRemoteSource : RemoteSource {

    @GET("/hist")
    suspend fun getCandles(
        @Query("t") tradingUnits: String,
        @Query("r") r: Char,
        @Query("limit") limit: Int,
        @Query("end") end: Int
    ): AppResponse<List<TradingData>, NetworkError>


}