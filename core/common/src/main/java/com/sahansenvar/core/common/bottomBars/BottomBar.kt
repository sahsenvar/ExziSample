package com.sahansenvar.core.common.bottomBars

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
sealed interface BottomBar: Parcelable{
    @Serializable
    @Parcelize
    data object Main: BottomBar

    @Serializable
    @Parcelize
    data object None: BottomBar
}