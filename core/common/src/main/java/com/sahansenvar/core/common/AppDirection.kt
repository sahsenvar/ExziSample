package com.sahansenvar.core.common

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppDirection {

    @Serializable
    data object TradingScreen : AppDirection

    @Serializable
    data object OrderbookScreen : AppDirection

}