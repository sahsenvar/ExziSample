package com.sahansenvar.feature.trading.presentation.screens.chartScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sahansenvar.core.common.extentions.inject
import com.sahansenvar.feature.trading.domain.models.CandleDomain
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.navigation.TradingNavigator
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.ChartAndInfoTabRow
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.ChartAndInfoTabs
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.ChartTabPage
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.InfoTabPage
import com.sahansenvar.feature.trading.presentation.uiStates.ChartUiState
import com.sahansenvar.feature.trading.presentation.uiStates.OrderBookUiState
import com.sahansenvar.feature.trading.presentation.viewModels.ChartViewModel


@Composable
fun ChartScreen(
    viewModel: ChartViewModel = inject(),
    navigator: TradingNavigator = inject(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle(initialValue = ChartUiState())
    ChartPage(
        candles = state.candles,
        orderbook = state.orderBook
    ) { action ->
        when (action) {
            is TradingActions.GetOrderBook -> viewModel.getOrderBook()
            is TradingActions.NavigateToChartScreen -> navigator.goToGraphScreen(action.title)
            is TradingActions.GetCandlesData -> viewModel.getCandleDatas("BTCUSDT", 5000, 1705363200)
            else -> Unit
        }
    }
}

@Composable
fun ChartPage(
    modifier: Modifier = Modifier,
    orderbook: OrderBookDomain,
    candles: List<CandleDomain>,
    onAction: (TradingActions) -> Unit
) {
    ChartAndInfoTabRow(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
    ) { currentPage ->
        when (currentPage) {
            ChartAndInfoTabs.Chart.ordinal -> ChartTabPage(
                candles = candles,
                orderBook = orderbook,
                onAction = onAction
            )

            ChartAndInfoTabs.Info.ordinal -> InfoTabPage()
        }

    }
}

//@Preview
//@Composable
//private fun Preview() {
//    ChartPage(state = ) {
//
//    }
//}