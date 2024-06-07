package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.chartAndInfoTabs.values
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderBookPage.forms.BuyOrSellPosition

@Composable
fun PreInfosRow(
    modifier: Modifier = Modifier,
    values: Values
) {
    Row(
        modifier = Modifier.then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            ExziText(
                modifier = Modifier.padding(bottom = 10.dp),
                text = values.lastValue,
                size = 26.sp,
                color = Color(0, 178, 124)
            )
            Row {
                ExziText(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = values.lastValue,
                    size = 13.sp,
                    color = Color(191, 194, 197)
                )
                ExziText(
                    modifier = Modifier,
                    text = values.lastValue,
                    size = 11.sp,
                    color = Color(0, 178, 124)
                )
            }

        }
        Row {
            Column(Modifier.padding(end = 10.dp)) {
                ExziText(text = "24h High", size = 9.5.sp, color = Color(137, 143, 148))
                ExziText(text = "24h Amount(${values.unitPair.first}", size = 11.sp, color = Color.White)
                Spacer(modifier = Modifier
                    .height(5.dp)
                    .width(30.dp))
                ExziText(text = "24h High", size = 9.5.sp, color = Color(137, 143, 148))
                ExziText(text = "24h Amount(${values.unitPair.first}", size = 11.sp, color = Color.White)
            }
            Column {
                ExziText(text = "24h High", size = 9.5.sp, color = Color(137, 143, 148))
                ExziText(text = "24h Amount(${values.unitPair.first}", size = 11.sp, color = Color.White)
                Spacer(modifier = Modifier
                    .height(5.dp)
                    .width(30.dp))
                ExziText(text = "24h High", size = 9.5.sp, color = Color(137, 143, 148))
                ExziText(text = "24h Amount(${values.unitPair.first}", size = 11.sp, color = Color.White)
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    PreInfosRow(
        modifier = Modifier.fillMaxWidth(),
        values = values)
}

data class Values(
    val unitPair: Pair<CurrencyUnit, CurrencyUnit>,
    val lastValue: String,
    val dollarEquivalent: String,
    val lastChanging: String,
    val lastChangingDirection: BuyOrSellPosition,
    val highestIn24h: String,
    val lowestIn24h: String,
    val amountIn24hForUnit1: String,
    val volumeIn24hForUnit2: String
)