package com.sahansenvar.trading.data.mappers

import com.sahansenvar.feature.trading.domain.models.TradingDomain
import com.sahansenvar.trading.data.models.TradingData
import org.koin.core.annotation.Factory

@Factory
class TradingMapper {

    fun mapToDomain(inValue: TradingData?) = kotlin.runCatching{
        requireNotNull(inValue)
        TradingDomain(
            close = requireNotNull(inValue.close),
            closeF = requireNotNull(inValue.closeF),
            high = requireNotNull(inValue.high),
            highF = requireNotNull(inValue.highF),
            low = requireNotNull(inValue.low),
            lowF = requireNotNull(inValue.lowF),
            open = requireNotNull(inValue.open),
            openF = requireNotNull(inValue.openF),
            pairId = requireNotNull(inValue.pairId),
            volume = requireNotNull(inValue.volume),
            volumeF = requireNotNull(inValue.volumeF)
        )
    }.getOrNull()

    fun mapToDomain(inValue: Collection<TradingData>): List<TradingDomain>{
        return inValue.mapNotNull { mapToDomain(it) }
    }
}