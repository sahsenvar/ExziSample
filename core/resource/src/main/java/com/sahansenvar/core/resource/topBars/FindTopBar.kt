package com.sahansenvar.core.resource.topBars

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sahansenvar.core.common.topBars.TopBar

@Composable
fun FindTopBar(
    topBarType: TopBar,
    onClickToPopBack: () -> Unit
) = when(topBarType){
    is TopBar.BackXTitle -> BackXTitleTopBar(title = topBarType.title, onClickToPopBack = onClickToPopBack)
    is TopBar.None -> Unit
}