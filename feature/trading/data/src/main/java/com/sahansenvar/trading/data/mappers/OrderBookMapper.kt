package com.sahansenvar.trading.data.mappers

import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import org.koin.core.annotation.Factory

@Factory
class OrderBookMapper(
    private val orderMapper: OrderMapper
) {
    fun mapToDomain(inValue: com.sahansenvar.trading.data.models.OrderBookData): OrderBookDomain {
        return OrderBookDomain(
            buy = orderMapper.mapToDomain(inValue.buy),
            sell = orderMapper.mapToDomain(inValue.sell)
        )
    }
}