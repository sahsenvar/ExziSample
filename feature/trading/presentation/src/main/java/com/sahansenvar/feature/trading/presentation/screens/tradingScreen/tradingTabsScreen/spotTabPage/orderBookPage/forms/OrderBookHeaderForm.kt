package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sahansenvar.core.resource.R
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.uiStates.OrderBookUiState

@Composable
fun OrderBookHeaderForm(
    modifier: Modifier = Modifier,
    state: OrderBookUiState,
    onAction: (TradingActions) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            modifier = Modifier
                .padding(end = 5.dp)
                .size(24.dp)
                .clickable { onAction(TradingActions.NavigateToChartScreen("BTC/USDT")) },
            painter = painterResource(id = R.drawable.ic_candles),
            tint = Color.White,
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { /* no-op */ },
            painter = painterResource(id = R.drawable.ic_tree_dots),
            tint = Color.White,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun Preview() {
    OrderBookHeaderForm(
        state = OrderBookUiState()
    ) {}
}