package com.sahansenvar.trading.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class OrderData(
    @SerialName("count")
    val count: Int?,
    @SerialName("price")
    val price: Long?,
    @SerialName("price_f")
    val priceF: String?,
    @SerialName("rate")
    val rate: Long?,
    @SerialName("rate_f")
    val rateF: String?,
    @SerialName("volume")
    val volume: Int?,
    @SerialName("volume_f")
    val volumeF: String?
)