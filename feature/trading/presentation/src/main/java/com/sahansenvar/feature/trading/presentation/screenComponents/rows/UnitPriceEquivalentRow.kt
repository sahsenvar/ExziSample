package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText

@Composable
fun UnitPriceEquivalentRow(
    modifier: Modifier = Modifier,
    equivalent: Double,
    unit: CurrencyUnit
) {
    ExziText(
        modifier = modifier,
        text = "=$equivalent $unit",
        size = 11.sp
    )
}

enum class CurrencyUnit{
    BTC,
    USDT,
}