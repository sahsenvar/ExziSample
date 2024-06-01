package com.sahansenvar.trading.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Times(
    @SerialName("close")    val close: Int?,
    @SerialName("open")     val `open`: Int?
)