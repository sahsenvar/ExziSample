package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit
import com.sahansenvar.feature.trading.presentation.screenComponents.forms.OrderBookForm
import com.sahansenvar.feature.trading.presentation.screenComponents.lists.Rotation
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.LastCurrencyRow
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.OthersRow
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.OrderBookHeaderForm
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition
import com.sahansenvar.feature.trading.presentation.uiStates.TradingUiState

@Composable
fun OrderBookFormPage(
    modifier: Modifier,
    state: TradingUiState,
    onAction: (TradingActions) -> Unit
){
    Column(modifier = modifier) {
        OrderBookHeaderForm(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
                .padding(bottom = 5.dp),
            state = state,
            onAction = onAction
        )
        OrderBookForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            quantityTextColor = Color.White,
            quantityRotation = Rotation.Rtl,
            buyOrSell = BuyOrSellPosition.Sell,
            unitPair = Pair(CurrencyUnit.USDT, CurrencyUnit.BTC),
            datas = state.orderBook.sell.take(6),
            onClicked = { onAction(TradingActions.PasteValueToAmountTextField(it)) }
        )
        LastCurrencyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            lastPrice = "42,899.99",
            dollarEquivalent = "42.893.05"
        )

        OrderBookForm(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            quantityTextColor = Color.White,
            quantityRotation = Rotation.Rtl,
            buyOrSell = BuyOrSellPosition.Buy,
            datas = state.orderBook.buy.take(6),
            onClicked = {onAction(TradingActions.PasteValueToAmountTextField(it)) }
        )

        OthersRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            onSelected = {},
            goToMarket = {}
        )
    }

    LaunchedEffect(key1 = "") {
        onAction(TradingActions.GetOrderBook)
    }

}

@Preview
@Composable
fun Preview() {
    OrderBookFormPage(
        modifier = Modifier.width(150.dp),
        state = TradingUiState()
    ){

    }
}