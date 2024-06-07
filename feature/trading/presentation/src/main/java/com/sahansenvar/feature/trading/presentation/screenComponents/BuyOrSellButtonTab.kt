package com.sahansenvar.feature.trading.presentation.screenComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sahansenvar.core.resource.ExziButton
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun BuyOrSellButtonTab(
    modifier: Modifier = Modifier,
    activeTab: BuyOrSellPosition,
    onActiveTabChanged: (BuyOrSellPosition) -> Unit
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .padding(0.dp)
                .background(shape = RoundedCornerShape(4.dp), color = Color(27, 31, 45))
        ) {
            ExziButton(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(0.5f),
                text = BuyOrSellPosition.Buy.name,
                colors = ButtonColors(
                    containerColor = Color(27, 31, 45),
                    contentColor = Color(156, 165, 196),
                    disabledContainerColor = Color(0, 178, 124),
                    disabledContentColor = Color.White,
                ),
                enable = activeTab == BuyOrSellPosition.Sell,
                onClicked = { onActiveTabChanged(BuyOrSellPosition.Buy) }
            )
            ExziButton(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(0.5f),
                text = BuyOrSellPosition.Sell.name,
                colors = ButtonColors(
                    containerColor = Color(27, 31, 45),
                    contentColor = Color(156, 165, 196),
                    disabledContainerColor = Color(246, 84, 84),
                    disabledContentColor = Color.White
                ),
                enable = activeTab == BuyOrSellPosition.Buy,
                onClicked = { onActiveTabChanged(BuyOrSellPosition.Sell) }
            )
        }
    }


}


@Preview
@Composable
private fun ActiveTabIsBuyTab() {
    BuyOrSellButtonTab(activeTab = BuyOrSellPosition.Buy) {}
}

@Preview
@Composable
private fun ActiveTabIsAskTab() {
    BuyOrSellButtonTab(activeTab = BuyOrSellPosition.Sell) {}
}
