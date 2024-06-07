package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderBookListForm(
    modifier: Modifier = Modifier,
    buyOrSellPosition: BuyOrSellPosition,
    orders: List<Pair<String, String>>,
    onClickItem: (String) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = orders) { order ->
            OrderBookItem(
                price = order.first,
                quantity = order.second,
                buyOrSellPosition = buyOrSellPosition,
                onClickItem = onClickItem
            )
        }
    }
}

@Composable
fun OrderBookItem(
    modifier: Modifier = Modifier,
    buyOrSellPosition: BuyOrSellPosition,
    price: String,
    quantity: String,
    onClickItem: (String) -> Unit
) {
    Row(
        modifier = modifier.clickable { onClickItem(price) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(end = 10.dp),
            text = price,
            fontSize = 11.sp,
            color = when (buyOrSellPosition) {
                BuyOrSellPosition.Buy -> Color(246, 84, 84)
                BuyOrSellPosition.Sell -> Color(0, 178, 124)
            },
        )
        Box {
            LinearProgressIndicator(
                progress = { quantity.toFloat() },
                modifier = Modifier
                    .height(17.dp)
                    .scale(scaleX = -1f, scaleY = 1f),
                color = when (buyOrSellPosition) {
                    BuyOrSellPosition.Buy -> Color(246, 84, 84, 100)
                    BuyOrSellPosition.Sell -> Color(0, 178, 124, 100)
                },
                trackColor = Color.Transparent,
            )
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.BottomEnd),
                text = quantity,
                color = Color.White,
                fontSize = 11.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderBookList() {
    val askOrders = listOf(
        Pair("42,897.99", "0.103999"),
        Pair("42,897.99", "0.148565"),
        Pair("42,897.99", "0.00148"),
        Pair("42,897.99", "0.06078"),
        Pair("42,897.99", "1.000000")
    )
    OrderBookListForm(
        Modifier.wrapContentWidth(),
        orders = askOrders,
        buyOrSellPosition = BuyOrSellPosition.Buy,
        onClickItem = { }
    )
}


enum class BuyOrSellPosition(val color: Color) {
    Buy(Color(0, 178, 124)),
    Sell(Color(246, 84, 84))
}