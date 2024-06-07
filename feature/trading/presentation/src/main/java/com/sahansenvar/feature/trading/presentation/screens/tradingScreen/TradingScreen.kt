package com.sahansenvar.feature.trading.presentation.screens.tradingScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sahansenvar.core.common.extentions.inject
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.models.TradingTabItem
import com.sahansenvar.feature.trading.presentation.navigation.TradingNavigator
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.convertTabPage.ConvertTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.marginTabPage.MarginTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.SpotTabPage
import com.sahansenvar.feature.trading.presentation.uiStates.OrderBookUiState
import com.sahansenvar.feature.trading.presentation.viewModels.ChartViewModel
import com.sahansenvar.feature.trading.presentation.viewModels.OrderBookViewModel


@Composable
fun TradingScreen(
    viewModel: OrderBookViewModel = inject(),
    navigator: TradingNavigator = inject()
) {

    val state by viewModel.state.collectAsStateWithLifecycle(OrderBookUiState())
    TradingPage(
        uiState = state
    ){action ->
        when(action){
            is TradingActions.GetOrderBook -> viewModel.getOrderBook()
            is TradingActions.NavigateToChartScreen -> navigator.goToGraphScreen(action.title)
            else -> Unit
        }
    }
}

@Composable
fun TradingPage(
    uiState: OrderBookUiState,
    onAction: (TradingActions) -> Unit
) {
    var selectedTabItem by remember { mutableStateOf(TradingTabItem.Spot) }
    val pagerState = rememberPagerState(selectedTabItem.ordinal) { TradingTabItem.entries.size }

    Column {
        LazyRow(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            items(items = TradingTabItem.entries) { item ->
                Tab(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .wrapContentSize(Alignment.TopStart),
                    selected = selectedTabItem == item,
                    onClick = { selectedTabItem = item },
                    selectedContentColor = Color(0xFFF4F5F5),
                    unselectedContentColor = Color(0xFFA4A8AD),
                    content = {
                        Text(
                            modifier = Modifier
                                .wrapContentSize(Alignment.CenterStart),
                            text = item.title,
                            fontSize = 15.sp
                        )
                    }
                )
            }
        }
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            state = pagerState,
            pageContent = {
                Box(contentAlignment = Alignment.TopCenter,modifier = Modifier.fillMaxSize()) {
                    when(selectedTabItem){
                        TradingTabItem.Spot -> SpotTabPage(
                            state = uiState,
                            onAction = onAction
                        )
                        TradingTabItem.Margin -> MarginTabPage()
                        TradingTabItem.Convert -> ConvertTabPage()
                    }
                }
            }
        )
    }

    LaunchedEffect(selectedTabItem) {
        pagerState.animateScrollToPage(selectedTabItem.ordinal)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTabItem = TradingTabItem.fromOrdinal(pagerState.currentPage)
    }
}

