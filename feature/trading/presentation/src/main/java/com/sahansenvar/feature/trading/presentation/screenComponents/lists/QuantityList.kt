package com.sahansenvar.feature.trading.presentation.screenComponents.lists

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.domain.models.OrderDomain
import com.sahansenvar.feature.trading.presentation.screenComponents.OrderbookScreenQuantityItem
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuantityList(
    modifier: Modifier = Modifier,
    buyOrSell: BuyOrSellPosition,
    rotation: Rotation,
    textColor: Color? = null,
    unit: CurrencyUnit? = null,
    datas: List<OrderDomain>,
    onClicked: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = when (rotation) {
            Rotation.Rtl -> Alignment.End
            Rotation.Ltr -> Alignment.Start
        }
    ) {
        unit?.let {
            stickyHeader {
                ExziText(
                    modifier = Modifier
                        .padding(bottom = 5.dp),
                    text = "Quantity($unit)",
                    size = 9.sp
                )
            }
        }
        items(datas) {
            OrderbookScreenQuantityItem(
                modifier = Modifier
                    .clickable { onClicked(it.volumeF) },
                buyOrSell = buyOrSell,
                textColor = textColor,
                rotation = rotation,
                quantity = it.volumeF,
                quantityF = Random.nextFloat().toString()
            )
        }
    }

}




enum class Rotation {
    Rtl,
    Ltr
}

@Preview
@Composable
private fun RtlAndSellWithHeader() {
    QuantityList(
        unit = CurrencyUnit.BTC,
        buyOrSell = BuyOrSellPosition.Sell,
        rotation = Rotation.Rtl,
        datas = emptyList(),
        onClicked = {}
    )
}