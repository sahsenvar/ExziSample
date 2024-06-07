package com.sahansenvar.trading.data.mappers

import com.sahansenvar.feature.trading.domain.models.CandleDomain
import com.sahansenvar.trading.data.models.TradingData
import org.koin.core.annotation.Factory

@Factory
class TradingMapper {

    fun mapToDomain(inValue: TradingData?) = kotlin.runCatching{
        requireNotNull(inValue)
        CandleDomain(
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

    fun mapToDomain(inValue: Collection<TradingData>): List<CandleDomain>{
        return inValue.mapNotNull { mapToDomain(it) }
    }
}