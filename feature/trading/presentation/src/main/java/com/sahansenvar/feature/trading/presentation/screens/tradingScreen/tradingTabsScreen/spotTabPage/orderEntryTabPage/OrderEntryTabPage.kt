package com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderEntryTabPage

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.R
import com.sahansenvar.core.resource.SegmentedProgressBar
import com.sahansenvar.feature.trading.presentation.screenComponents.textFields.AmountTextField
import com.sahansenvar.feature.trading.presentation.screenComponents.BuyOrSellButtonTab
import com.sahansenvar.feature.trading.presentation.screenComponents.buttons.BuyOrSellButton
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.MaxBuyOrSellRow
import com.sahansenvar.feature.trading.presentation.screenComponents.dropDownMenus.OrderTypeDropDownMenu
import com.sahansenvar.feature.trading.presentation.screenComponents.textFields.TotalTextField
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.UnitPriceEquivalentRow
import com.sahansenvar.feature.trading.presentation.screenComponents.textFields.UnitPriceTextField
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun OrderEntryForm(
    modifier: Modifier = Modifier,
    activeBuyOrSellPosition: BuyOrSellPosition = BuyOrSellPosition.Buy,
    textFieldValue: String = ""
) {
    var activeTab by remember { mutableStateOf(activeBuyOrSellPosition) }
    Column(modifier.then(modifier)) {
        //Trading Header
        Row(Modifier.padding(bottom = 10.dp)) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 6.dp),
                painter = painterResource(id = R.drawable.ic_trading),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(end = 6.dp),
                text = "BTC/USDT",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(245, 245, 245)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = "+2,44%",
                fontSize = 12.sp,
                color = Color(46, 209, 150)
            )
        }
        BuyOrSellButtonTab(
            modifier = Modifier
                .padding(bottom = 10.dp),
            activeTab = activeTab,
            onActiveTabChanged = { newActiveTab -> activeTab = newActiveTab }
        )

        OrderTypeDropDownMenu(
            modifier = Modifier
                .padding(bottom = 10.dp),
            menuModifier = Modifier
                .fillMaxWidth(0.625f),
        )
        UnitPriceTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            firstValue = textFieldValue
        )
        UnitPriceEquivalentRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            equivalent = 1.21,
            unit = CurrencyUnit.USDT
        )
        AmountTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            unit = CurrencyUnit.BTC
        )
        SegmentedProgressBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            onClicked = {}
        )
        TotalTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            unit = CurrencyUnit.USDT
        )
        MaxBuyOrSellRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 13.dp),
            buyOrSellPosition = activeTab,
            unit = CurrencyUnit.BTC,
            maxValue = 0.0f
        )
        BuyOrSellButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            buttonModifier = Modifier
                .height(35.dp),
            buyOrSellPosition = activeTab,
            onClicked = { orderDirection ->
                when (orderDirection) {
                    BuyOrSellPosition.Buy -> {}
                    BuyOrSellPosition.Sell -> {}
                }
            },
        )
    }
}

enum class OrderType {
    Limit,
    Stop,
    Market,
}

@Preview
@Composable
fun ActiveOrderDirectionIsBuy() {
    OrderEntryForm(
        activeBuyOrSellPosition = BuyOrSellPosition.Buy,
    )
}

@Preview
@Composable
fun ActiveOrderDirectionIsSell() {
    OrderEntryForm(
        activeBuyOrSellPosition = BuyOrSellPosition.Sell,
    )
}