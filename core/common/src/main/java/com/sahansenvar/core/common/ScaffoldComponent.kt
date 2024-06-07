package com.sahansenvar.core.common

import com.sahansenvar.core.common.bottomBars.BottomBar
import com.sahansenvar.core.common.topBars.TopBar

interface ScaffoldComponent {
    val bottomBar: BottomBar?
    val topBar: TopBar?
}