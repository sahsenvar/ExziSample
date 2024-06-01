package com.sahansenvar.trading.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class TradingData(
    @SerialName("close")    val close: Long?,
    @SerialName("close_f")  val closeF: String?,
    @SerialName("high")     val high: Long?,
    @SerialName("high_f")   val highF: String?,
    @SerialName("low")      val low: Long?,
    @SerialName("low_f")    val lowF: String?,
    @SerialName("open")     val open: Long?,
    @SerialName("open_f")   val openF: String?,
    @SerialName("pair_id")  val pairId: Int?,
    @SerialName("time")     val time: Int?,
    @SerialName("times")    val times: Times?,
    @SerialName("volume")   val volume: Long?,
    @SerialName("volume_f") val volumeF: String?
)