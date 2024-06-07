package com.sahansenvar.trading.data.mappers

import com.sahansenvar.feature.trading.domain.models.OrderDomain
import com.sahansenvar.trading.data.models.OrderData
import org.koin.core.annotation.Factory

@Factory
class OrderMapper{
    fun mapToDomain(inValue: OrderData?): OrderDomain? = runCatching{
        requireNotNull(inValue)
        OrderDomain(
            count = requireNotNull(inValue.count),
            price = requireNotNull(inValue.price),
            priceF = requireNotNull(inValue.priceF),
            rate = requireNotNull(inValue.rate),
            rateF = requireNotNull(inValue.rateF),
            volume = requireNotNull(inValue.volume),
            volumeF = requireNotNull(inValue.volumeF)
        )
    }.onFailure {
        // send report to crashlytics
    }.getOrNull()

    fun mapToDomain(inValue: List<OrderData?>?): List<OrderDomain> {
        return inValue?.mapNotNull { mapToDomain(it) } ?: emptyList()
    }
}