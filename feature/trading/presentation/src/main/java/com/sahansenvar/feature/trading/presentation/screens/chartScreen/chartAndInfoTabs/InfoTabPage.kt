package com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText

@Composable
fun InfoTabPage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .height(370.dp)
            .background(Color.Red)
    ) {
        ExziText(
            text = "INFO TAB PAGE",
            size = 30.sp,
            color = Color.White
        )
    }
}