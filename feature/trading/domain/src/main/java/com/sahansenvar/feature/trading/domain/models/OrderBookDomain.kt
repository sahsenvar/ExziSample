package com.sahansenvar.feature.trading.domain.models

data class OrderBookDomain(
    val buy: List<OrderDomain>,
    val sell: List<OrderDomain>
)
