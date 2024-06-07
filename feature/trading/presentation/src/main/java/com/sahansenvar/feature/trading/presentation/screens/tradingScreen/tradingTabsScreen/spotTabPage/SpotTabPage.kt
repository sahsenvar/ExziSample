package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.MyOrdersTabRow
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.OrderBookFormPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderEntryTabPage.OrderEntryForm
import com.sahansenvar.feature.trading.presentation.uiStates.OrderBookUiState

@Composable
fun SpotTabPage(
    state: OrderBookUiState,
    onAction: (TradingActions) -> Unit
) {
    var amountTextFieldValue by remember { mutableStateOf("")}
    Column{
        Row(Modifier.fillMaxWidth()) {
            OrderEntryForm(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.6f)
                    .padding(start = 5.dp, end = 5.dp),
                textFieldValue = amountTextFieldValue
            )
            OrderBookFormPage(
                modifier = Modifier
                    .weight(.4f)
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 10.dp),
                state = state,
                onAction = { action ->
                    if(action is TradingActions.PasteValueToAmountTextField)
                        amountTextFieldValue = action.value
                    else onAction(action)
                }
            )
        }
        MyOrdersTabRow(
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview
@Composable
fun Preview() {
    SpotTabPage(
        state = OrderBookUiState(),
    ){

    }
}