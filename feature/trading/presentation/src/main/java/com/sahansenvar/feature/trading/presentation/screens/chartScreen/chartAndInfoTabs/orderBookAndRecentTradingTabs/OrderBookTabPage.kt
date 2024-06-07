package com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.orderBookAndRecentTradingTabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.screenComponents.forms.OrderBookForm
import com.sahansenvar.feature.trading.presentation.screenComponents.lists.Rotation
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun OrderBookTabPage(
    modifier: Modifier = Modifier,
    orderBookData: OrderBookDomain,
    onAction: (TradingActions) -> Unit
) {
    Column(modifier = modifier) {
        // OrderBookHeaderRow()
        Row(modifier = Modifier.height(370.dp)){
            OrderBookForm(
                modifier = Modifier.weight(1f),
                quantityRotation = Rotation.Rtl,
                buyOrSell = BuyOrSellPosition.Buy,
                datas = orderBookData.buy,
                priceTextColor = Color.White,
                onClicked = { /*no-op*/ }
            )
            OrderBookForm(
                modifier = Modifier.weight(1f),
                quantityRotation = Rotation.Ltr,
                buyOrSell = BuyOrSellPosition.Sell,
                datas = orderBookData.sell,
                priceTextColor = Color.White,
                onClicked = { /*no-op*/ }
            )
        }
    }
}