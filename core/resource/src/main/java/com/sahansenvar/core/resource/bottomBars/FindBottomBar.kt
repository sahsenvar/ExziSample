package com.sahansenvar.core.resource.bottomBars

import androidx.compose.runtime.Composable
import com.sahansenvar.core.common.bottomBars.BottomBar

@Composable
fun FindBottomBar(
    bottomBar: BottomBar
) = when (bottomBar) {
    BottomBar.Main -> MainBottomBar()
    BottomBar.None -> Unit
}