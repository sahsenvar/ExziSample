package com.sahansenvar.feature.trading.domain.models

import androidx.annotation.Keep

@Keep
data class CandleDomain(
    val close: Long,
    val closeF: String,
    val high: Long,
    val highF: String,
    val low: Long,
    val lowF: String,
    val open: Long,
    val openF: String,
    val pairId: Int,
    val volume: Long,
    val volumeF: String,
)