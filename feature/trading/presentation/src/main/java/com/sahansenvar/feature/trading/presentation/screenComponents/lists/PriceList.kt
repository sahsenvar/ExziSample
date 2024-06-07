package com.sahansenvar.feature.trading.presentation.screenComponents.lists

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition
import java.text.DecimalFormat
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PriceList(
    modifier: Modifier = Modifier,
    rotation: Rotation,
    color: Color? = null,
    buyOrSell: BuyOrSellPosition,
    unit: CurrencyUnit? = null,
    datas: List<String> = exampleDatas,
    onClicked: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = when (rotation) {
            Rotation.Rtl -> Alignment.End
            Rotation.Ltr -> Alignment.Start
        },
        verticalArrangement = Arrangement.Center
    ) {
        unit?.let {
            stickyHeader {
                ExziText(
                    modifier = Modifier
                        .padding(bottom = 5.dp),
                    text = "Price($unit)",
                    size = 9.sp
                )
            }
        }
        items(datas) {
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .fillMaxWidth(),
                contentAlignment = when (rotation) {
                    Rotation.Rtl -> Alignment.CenterEnd
                    Rotation.Ltr -> Alignment.CenterStart
                }
            ) {
                ExziText(
                    modifier = Modifier
                        .clickable { onClicked(it) },
                    text = it,
                    size = 11.sp,
                    color = color ?: when (buyOrSell) {
                        BuyOrSellPosition.Buy -> Color(0, 178, 124)
                        BuyOrSellPosition.Sell -> Color(246, 84, 84)
                    }
                )
            }

        }
    }
}

val exampleDatas: List<String>
    get() = List(6) {
        val number = Random.nextFloat().times(100)
        DecimalFormat("#,###.#######").format(number)
    }.sortedDescending()

@Preview
@Composable
private fun LtlAndBuy() {
    PriceList(
        buyOrSell = BuyOrSellPosition.Buy,
        unit = CurrencyUnit.USDT,
        rotation = Rotation.Ltr,
        datas = exampleDatas,
        onClicked = {}
    )
}

@Preview
@Composable
private fun LtlAndSell() {
    PriceList(
        buyOrSell = BuyOrSellPosition.Sell,
        unit = CurrencyUnit.USDT,
        rotation = Rotation.Ltr,
        datas = exampleDatas,
        onClicked = {}
    )
}

@Preview
@Composable
private fun RtlAndBuy() {
    PriceList(
        buyOrSell = BuyOrSellPosition.Buy,
        unit = CurrencyUnit.USDT,
        rotation = Rotation.Rtl,
        datas = exampleDatas,
        onClicked = {}
    )
}

@Preview
@Composable
private fun RtlAndSell() {
    PriceList(
        buyOrSell = BuyOrSellPosition.Sell,
        unit = CurrencyUnit.USDT,
        rotation = Rotation.Rtl,
        datas = exampleDatas,
        onClicked = {}
    )
}

@Preview
@Composable
private fun RtlAndSellWithCustomColor() {
    PriceList(
        buyOrSell = BuyOrSellPosition.Sell,
        unit = CurrencyUnit.USDT,
        rotation = Rotation.Rtl,
        color = Color.White,
        datas = exampleDatas,
        onClicked = {}
    )
}

@Preview
@Composable
private fun RtlAndSellWithCustomColorAndWithoutHeader() {
    PriceList(
        buyOrSell = BuyOrSellPosition.Sell,
        rotation = Rotation.Rtl,
        color = Color.White,
        datas = exampleDatas,
        onClicked = {}
    )
}