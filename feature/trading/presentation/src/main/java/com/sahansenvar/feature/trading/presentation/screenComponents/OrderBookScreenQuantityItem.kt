package com.sahansenvar.feature.trading.presentation.screenComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.presentation.screenComponents.lists.Rotation
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun OrderbookScreenQuantityItem(
    modifier: Modifier = Modifier,
    rotation: Rotation,
    buyOrSell: BuyOrSellPosition,
    quantityF: String,
    textColor: Color? = null,
    quantity: String
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .height(20.dp),
        contentAlignment = when (rotation) {
            Rotation.Rtl -> Alignment.CenterEnd
            Rotation.Ltr -> Alignment.CenterStart
        }
    ) {
        LinearProgressIndicator(
            progress = { quantityF.toFloat() },
            modifier = Modifier
                .height(20.dp)
                .scale(
                    when (rotation) {
                        Rotation.Rtl -> -1f
                        Rotation.Ltr -> 1f
                    }, 1f
                ),
            color = when (buyOrSell) {
                BuyOrSellPosition.Sell -> Color(246, 84, 84, 50)
                BuyOrSellPosition.Buy -> Color(0, 178, 124, 50)
            },
            trackColor = Color.Transparent,
        )
        ExziText(
            modifier = Modifier,
            text = quantity,
            size = 11.sp,
            color = textColor ?: when (buyOrSell) {
                BuyOrSellPosition.Buy -> Color(0, 178, 124)
                BuyOrSellPosition.Sell -> Color(246, 84, 84)
            }
        )
    }
}

@Preview
@Composable
private fun RtlAndBuy() {
    OrderbookScreenQuantityItem(
        rotation = Rotation.Rtl,
        buyOrSell = BuyOrSellPosition.Buy,
        quantityF = "0.83",
        quantity = "0.83"
    )
}

@Preview
@Composable
private fun RtlAndSell() {
    OrderbookScreenQuantityItem(
        rotation = Rotation.Rtl,
        buyOrSell = BuyOrSellPosition.Sell,
        quantityF = "0.83",
        quantity = "0.83"
    )
}

@Preview
@Composable
private fun LtrAndBuy() {
    OrderbookScreenQuantityItem(
        rotation = Rotation.Ltr,
        buyOrSell = BuyOrSellPosition.Buy,
        quantityF = "0.83",
        quantity = "0.83"
    )
}

@Preview
@Composable
private fun LtrAndSell() {
    OrderbookScreenQuantityItem(
        rotation = Rotation.Ltr,
        buyOrSell = BuyOrSellPosition.Sell,
        quantityF = "0.83",
        quantity = "0.83"
    )
}