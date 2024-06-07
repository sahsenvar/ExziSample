package com.sahansenvar.feature.trading.domain.models

data class OrderDomain(
    val count: Int,
    val price: Long,
    val priceF: String,
    val rate: Long,
    val rateF: String,
    val volume: Int,
    val volumeF: String
)
