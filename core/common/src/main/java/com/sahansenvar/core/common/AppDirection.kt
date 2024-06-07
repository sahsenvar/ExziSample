package com.sahansenvar.core.common

import android.os.Parcelable
import com.sahansenvar.core.common.bottomBars.BottomBar
import com.sahansenvar.core.common.topBars.TopBar
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
sealed interface AppDirection: ScaffoldComponent, Parcelable {

    @Serializable
    @Parcelize
    data class TradingScreen(
        override val topBar: TopBar = TopBar.None,
        override val bottomBar: BottomBar = BottomBar.Main
    ) : AppDirection

    @Serializable
    @Parcelize
    data class ChartScreen(
        override val topBar: TopBar = TopBar.None,
        override val bottomBar: BottomBar = BottomBar.None,
    ) : AppDirection

}