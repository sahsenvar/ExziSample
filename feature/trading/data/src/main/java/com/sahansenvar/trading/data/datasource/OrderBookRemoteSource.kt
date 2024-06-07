package com.sahansenvar.trading.data.datasource

import com.sahansenvar.core.common.basesAndMarkers.RemoteSource
import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.trading.data.models.OrderBookData
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OrderBookRemoteSource: RemoteSource {

    @GET("/book/list")
    suspend fun getOrderBookDatas(
        @Query("pair_id") pairId: Int,
        @Query("buy") buy: Int,
        @Query("sell") sell: Int
    ): OrderBookData

}