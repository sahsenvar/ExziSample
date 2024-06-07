package com.sahansenvar.feature.trading.presentation.screenComponents.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.sahansenvar.core.resource.BuyButton
import com.sahansenvar.core.resource.SellButton
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun BuyOrSellButton(
    modifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier,
    buyOrSellPosition: BuyOrSellPosition,
    onClicked: (BuyOrSellPosition) -> Unit
) {
    Box(modifier) {
        when (buyOrSellPosition) {
            BuyOrSellPosition.Buy -> BuyButton(buttonModifier) { onClicked(buyOrSellPosition) }
            BuyOrSellPosition.Sell -> SellButton(buttonModifier) { onClicked(buyOrSellPosition) }
        }
    }
}


@Preview
@Composable
private fun BuyButton() {
    BuyOrSellButton(buyOrSellPosition = BuyOrSellPosition.Buy) {}
}

@Preview
@Composable
private fun SellButton() {
    BuyOrSellButton(buyOrSellPosition = BuyOrSellPosition.Sell) {}
}