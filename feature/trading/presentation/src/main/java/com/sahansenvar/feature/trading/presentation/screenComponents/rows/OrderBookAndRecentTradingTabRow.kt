package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.orderBookAndRecentTradingTabs.OrderBookTabPage
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.orderBookAndRecentTradingTabs.RecentTradingTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.OrderTabs

@Composable
fun OrderBookAndRecentTradingTabRow(
    modifier: Modifier = Modifier,
    onPageChanger: @Composable (page: Int) -> Unit
) {
    var selectedTab by remember { mutableStateOf(OrderBookAndRecentTradingTabs.OrderBook) }
    val pagerState = rememberPagerState(selectedTab.ordinal) { OrderTabs.entries.size }
    Column {
        Box {
            HorizontalDivider(
                modifier = modifier
                    .align(Alignment.BottomCenter)
            )
            TabRow(
                modifier = modifier
                    .align(Alignment.CenterStart)
                    .fillMaxWidth(0.38f),
                selectedTabIndex = selectedTab.ordinal,
                containerColor = Color(14, 17, 27),
                contentColor = Color.Unspecified,
                indicator = { tabPositions ->
                    if (selectedTab.ordinal < tabPositions.size) {
                        TabRowDefaults.PrimaryIndicator(
                            modifier = Modifier
                                .tabIndicatorOffset(tabPositions[selectedTab.ordinal]),
                            width = 40.dp,
                            color = Color(57, 163, 208)
                        )
                    }
                }
            ) {
                OrderBookAndRecentTradingTabs.entries.forEach { tab ->
                    Tab(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(0.dp),
                        selected = tab == selectedTab,
                        text = { ExziText(text = tab.title, size = 12.sp) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color(164, 168, 173),
                        onClick = { selectedTab = tab }
                    )
                }
            }
        }
        HorizontalPager(
            state = pagerState,
            pageContent = { onPageChanger(it) }
        )
    }

    LaunchedEffect(selectedTab) {
        pagerState.animateScrollToPage(selectedTab.ordinal)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTab = OrderBookAndRecentTradingTabs.fromOrdinal(pagerState.currentPage)
    }
}

enum class OrderBookAndRecentTradingTabs(val title: String) {
    OrderBook(title = "Chart"),
    RecentTrading(title = "Info");

    companion object {
        fun fromOrdinal(no: Int) = entries.find { no == it.ordinal } ?: OrderBook
    }
}

// ###############################################
//@Preview
//@Composable
//private fun Preview() {
//    OrderBookAndRecentTradingTabRow() { currentPage ->
//        when (currentPage) {
//            OrderBookAndRecentTradingTabs.OrderBook.ordinal -> OrderBookTabPage(
//                modifier = Modifier.fillMaxSize(),
//                state = state
//            )
//            OrderBookAndRecentTradingTabs.RecentTrading.ordinal -> RecentTradingTabPage()
//        }
//    }
//}