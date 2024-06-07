package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText

@Composable
fun LastCurrencyRow(
    modifier: Modifier = Modifier,
    lastPrice: String,
    dollarEquivalent: String
) {
    Box(
        modifier = modifier,
    ) {
        Column {
            ExziText(text = lastPrice, size = 15.sp, color = Color(0, 178, 124))
            ExziText(text = "=$dollarEquivalent", size = 11.sp)
        }

    }
}