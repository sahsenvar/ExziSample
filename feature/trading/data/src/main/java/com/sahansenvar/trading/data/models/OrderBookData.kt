package com.sahansenvar.trading.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class OrderBookData(
    @SerialName("buy")
    val buy: List<OrderData?>?,
    @SerialName("sell")
    val sell: List<OrderData?>?
)