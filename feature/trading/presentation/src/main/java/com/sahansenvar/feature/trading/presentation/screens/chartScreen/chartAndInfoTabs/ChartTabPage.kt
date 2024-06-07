package com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.BuyButton
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.core.resource.SellButton
import com.sahansenvar.feature.trading.domain.models.CandleDomain
import com.sahansenvar.feature.trading.domain.models.OrderBookDomain
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.screenComponents.charts.MainChart
import com.sahansenvar.feature.trading.presentation.screenComponents.charts.SecondaryChart
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.MainChartFilterRow
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.OrderBookAndRecentTradingTabRow
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.OrderBookAndRecentTradingTabs
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.PreInfosRow
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.SecondaryChartFilterRow
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.Values
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.orderBookAndRecentTradingTabs.OrderBookTabPage
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.orderBookAndRecentTradingTabs.RecentTradingTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition
import com.sahansenvar.feature.trading.presentation.uiStates.ChartUiState
import com.sahansenvar.feature.trading.presentation.uiStates.OrderBookUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun ChartTabPage(
    modifier: Modifier = Modifier,
    orderBook: OrderBookDomain,
    candles: List<CandleDomain>,
    onAction: (TradingActions) -> Unit
) {

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier)
                .padding(horizontal = 10.dp)
        ) {
            PreInfosRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                values = values
            )

            MainChartFilterRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
            ) {
                //todo: Will get triggered then click the text buttons
            }

            MainChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                candleDatas = candles
            )

            SecondaryChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
            )
            SecondaryChartFilterRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
            ) {
                //todo: Will get triggered then click the text buttons
            }

            OrderBookAndRecentTradingTabRow { currentPage ->
                when (currentPage) {
                    OrderBookAndRecentTradingTabs.OrderBook.ordinal -> OrderBookTabPage(
                        orderBookData = orderBook,
                        onAction = onAction
                    )

                    OrderBookAndRecentTradingTabs.RecentTrading.ordinal -> RecentTradingTabPage()
                }
            }
        }

        Row(
            modifier
                .align(Alignment.BottomCenter)
                .height(60.dp)
                .fillMaxWidth()
                .background(Color(27, 31, 45)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = com.sahansenvar.core.resource.R.drawable.ic_alert),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                ExziText(text = "Alert", size = 10.sp)
            }
            Column(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = com.sahansenvar.core.resource.R.drawable.ic_margin),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                ExziText(text = "Margin", size = 10.sp)
            }

            VerticalDivider(
                modifier = Modifier
                    .height(30.dp)
                    .width(1.dp)
                    .background(Color(51, 60, 87))
                    .padding(horizontal = 10.dp)
            )

            BuyButton(
                modifier
                    .width(120.dp)
                    .padding(horizontal = 10.dp)
            ) {

            }
            SellButton(
                modifier
                    .width(120.dp)
                    .padding(horizontal = 10.dp)
            ) {

            }
        }
    }

    LaunchedEffect("1") {
        withContext(Dispatchers.IO) {
            onAction(TradingActions.GetOrderBook)
        }
    }
    LaunchedEffect("2") {
        withContext(Dispatchers.IO) {
            onAction(TradingActions.GetCandlesData)
        }
    }
}

//@Preview
//@Composable
//private fun Preview() {
//    ChartTabPage()
//}

val values = Values(
    unitPair = Pair(CurrencyUnit.BTC, CurrencyUnit.USDT),
    lastValue = "42,897.9",
    dollarEquivalent = "42,893.05",
    lastChanging = "2,44",
    lastChangingDirection = BuyOrSellPosition.Buy,
    highestIn24h = "43.787,18",
    lowestIn24h = "42.421,09",
    amountIn24hForUnit1 = "3.762,10",
    volumeIn24hForUnit2 = "112.76M"
)