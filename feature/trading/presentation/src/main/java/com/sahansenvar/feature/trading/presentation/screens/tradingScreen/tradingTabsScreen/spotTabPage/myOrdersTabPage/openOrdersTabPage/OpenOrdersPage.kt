package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.openOrdersTabPage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.presentation.screenComponents.cards.OpenOrderCard
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderEntryTabPage.OrderType

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OpenOrdersTabPage(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
    ) {
        stickyHeader {
            Box(
                contentAlignment = Alignment.TopEnd
            ){
                ExziText(
                    modifier = Modifier
                        .clickable { /*onClickedToCancelAll()*/ }
                        .padding(bottom = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    text = "Cancel All",
                    size = 12.sp,
                    align = TextAlign.End,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
        items(items = openOrders) {
            OpenOrderCard(
                modifier = Modifier.padding(bottom = 10.dp, end = 10.dp),
                cardData = it,
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                color = Color(51, 60, 87)
            )
        }
    }
}


val openOrders = listOf(
    OpenOrderItem(
        unitPair = Pair(CurrencyUnit.BTC, CurrencyUnit.USDT),
        timestamp = "08/09 - 11:29:05",
        buyOrSell = BuyOrSellPosition.Sell,
        orderType = OrderType.Limit,
        amount = 8f,
        totalAmount = 18f,
        price = 60.0f
    )
)


data class OpenOrderItem(
    val unitPair: Pair<CurrencyUnit, CurrencyUnit>,
    val timestamp: String,
    val buyOrSell: BuyOrSellPosition,
    val orderType: OrderType,
    val amount: Float,
    val totalAmount: Float,
    val price: Float,
)