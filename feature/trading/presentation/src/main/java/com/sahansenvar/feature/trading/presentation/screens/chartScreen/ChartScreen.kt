package com.sahansenvar.feature.trading.presentation.screens.chartScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sahansenvar.core.common.AppDirection
import com.sahansenvar.core.common.extentions.inject
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.navigation.TradingNavigator
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.ChartAndInfoTabRow
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.ChartAndInfoTabs
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.ChartTabPage
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.InfoTabPage
import com.sahansenvar.feature.trading.presentation.uiStates.TradingUiState
import com.sahansenvar.feature.trading.presentation.viewModels.TradingViewModel


@Composable
fun ChartScreen(
    viewModel: TradingViewModel = inject(),
    navigator: TradingNavigator = inject(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ChartPage(state = state) { action ->
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
    state: TradingUiState,
    onAction: (TradingActions) -> Unit
) {
    ChartAndInfoTabRow(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
    ) { currentPage ->
        when (currentPage) {
            ChartAndInfoTabs.Chart.ordinal -> ChartTabPage(
                state = state,
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