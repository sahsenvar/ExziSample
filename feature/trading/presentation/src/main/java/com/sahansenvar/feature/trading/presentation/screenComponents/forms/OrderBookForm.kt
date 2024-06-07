package com.sahansenvar.feature.trading.presentation.screenComponents.forms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sahansenvar.feature.trading.domain.models.OrderDomain
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit
import com.sahansenvar.feature.trading.presentation.screenComponents.lists.PriceList
import com.sahansenvar.feature.trading.presentation.screenComponents.lists.QuantityList
import com.sahansenvar.feature.trading.presentation.screenComponents.lists.Rotation
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun OrderBookForm(
    modifier: Modifier = Modifier,
    quantityRotation: Rotation,
    buyOrSell: BuyOrSellPosition,
    priceTextColor: Color? = null,
    quantityTextColor: Color? = null,
    unitPair: Pair<CurrencyUnit, CurrencyUnit>? = null,
    datas: List<OrderDomain>,
    onClicked: (String) -> Unit
) {
    Box(modifier = modifier) {
        Box{
            PriceList(
                modifier = Modifier.fillMaxWidth(),
                rotation = when (quantityRotation) {
                    Rotation.Rtl -> Rotation.Ltr
                    Rotation.Ltr -> Rotation.Rtl
                },
                color = priceTextColor,
                buyOrSell = buyOrSell,
                unit = unitPair?.first,
                datas = datas.map { it.priceF },
                onClicked = onClicked
            )
            QuantityList(
                modifier = Modifier.fillMaxWidth(),
                rotation = quantityRotation,
                buyOrSell = buyOrSell,
                textColor = quantityTextColor,
                unit = unitPair?.second,
                datas = datas,
                onClicked = onClicked
            )
        }
    }
}