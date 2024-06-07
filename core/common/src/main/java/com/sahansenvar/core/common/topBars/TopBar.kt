package com.sahansenvar.core.common.topBars

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
sealed interface TopBar: Parcelable {
    @Serializable
    @Parcelize
    data class BackXTitle(
        val title: String
    ): TopBar

    @Serializable
    @Parcelize
    data object None: TopBar
}