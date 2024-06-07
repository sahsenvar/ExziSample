package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.core.resource.R
import com.sahansenvar.feature.trading.presentation.models.TradingTabItem
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.fundsTabPage.FundsTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.openOrdersTabPage.OpenOrdersTabPage
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.orderHistoryTabPage.OrderHistoryTabPage

@Composable
fun MyOrdersTabRow(
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(OrderTabs.OpenOrders) }
    val pagerState = rememberPagerState(selectedTab.ordinal) { OrderTabs.entries.size }

    Column {
        TabRow(
            modifier = Modifier.then(modifier),
            selectedTabIndex = selectedTab.ordinal,
            containerColor = Color.Transparent,
            contentColor = Color.White,
            divider = {
                HorizontalDivider(
                    color = Color(51, 60, 87),
                    modifier = Modifier.padding(top = 10.dp)
                )
            },
            indicator = { tabPositions ->
                if (selectedTab.ordinal < tabPositions.size) {
                    TabRowDefaults.PrimaryIndicator(
                        Modifier
                            .tabIndicatorOffset(tabPositions[selectedTab.ordinal]),
                        width = 20.dp,
                        color = Color(57, 163, 208)
                    )
                }
            },
        ) {
            OrderTabs.entries.forEach { tab ->
                Tab(
                    modifier = Modifier.padding(end = 10.dp),
                    selected = tab == selectedTab,
                    onClick = { selectedTab = tab },
                    content = {
                        ExziText(
                            text = tab.title,
                            size = 13.sp,
                            color = Color.White
                        )
                    },
                )
            }

            Icon(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.End),
                painter = painterResource(id = R.drawable.ic_history),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        HorizontalPager(
            modifier = Modifier,
            state = pagerState
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            ) {
                when (page) {
                    OrderTabs.OpenOrders.ordinal -> OpenOrdersTabPage()
                    OrderTabs.OrderHistory.ordinal -> OrderHistoryTabPage()
                    OrderTabs.Funds.ordinal -> FundsTabPage()
                }
            }
        }
    }

    LaunchedEffect(selectedTab) {
        pagerState.animateScrollToPage(selectedTab.ordinal)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTab = OrderTabs.fromOrdinal(pagerState.currentPage)
    }
}

enum class OrderTabs(val title: String) {
    OpenOrders(title = "Open Order"),
    OrderHistory(title = "Order History"),
    Funds(title = "Funds");

    companion object {
        fun fromOrdinal(no: Int) = entries.find { no == it.ordinal } ?: OpenOrders
    }
}