package com.sahansenvar.trading.data.mappers

import com.sahansenvar.feature.trading.domain.models.TradingDomain
import com.sahansenvar.trading.data.models.TradingData
import org.koin.core.annotation.Factory

@Factory
class TradingMapper {

    fun mapToDomain(inValue: TradingData): TradingDomain{
        return TradingDomain()
    }

    fun mapToDomain(inValue: Collection<TradingData>): List<TradingDomain>{
        return inValue.map { mapToDomain(it) }
    }
}