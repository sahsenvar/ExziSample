package com.sahansenvar.feature.orderbook.data.repositories

import com.sahansenvar.feature.orderbook.data.datasource.OrderbookLocalSource
import com.sahansenvar.feature.orderbook.data.datasource.OrderBookRemoteSource
import org.koin.core.annotation.Factory

@Factory
class OrderBookRepositoryImpl(
    private val orderbookRemoteSource: OrderBookRemoteSource,
    private val orderBookLocalSource: OrderbookLocalSource
): OrderbookRepository {

}