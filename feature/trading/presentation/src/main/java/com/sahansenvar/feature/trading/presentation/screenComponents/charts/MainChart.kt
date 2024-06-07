package com.sahansenvar.feature.trading.presentation.screenComponents.charts

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottomAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStartAxis
import com.patrykandpatrick.vico.compose.cartesian.fullWidth
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberCandlestickCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.core.cartesian.HorizontalLayout
import com.patrykandpatrick.vico.core.cartesian.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.RandomCartesianModelGenerator
import com.patrykandpatrick.vico.core.cartesian.data.candlestickSeries
import com.sahansenvar.feature.trading.presentation.action.TradingActions
import com.sahansenvar.feature.trading.presentation.uiStates.TradingUiState
import com.sahansenvar.presentation.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("RestrictedApi")
@Composable
fun MainChart(
    modifier: Modifier = Modifier,
    state: TradingUiState,
    onAction: (TradingActions) -> Unit
) {
    val modelProducer = remember { CartesianChartModelProducer.build() }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (state.candles.isEmpty()) {
            Box(
                modifier = Modifier
                    .then(modifier)
                    .fillMaxWidth()
                    .height(360.dp)
                    .background(color = Color(27, 31, 45), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = com.sahansenvar.core.resource.R.drawable.ic_chart_loading),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        } else {
            CartesianChartHost(
                chart = rememberCartesianChart(
                    rememberCandlestickCartesianLayer(),
                    startAxis = rememberStartAxis(),
                    bottomAxis = rememberBottomAxis(
                        guideline = null,
                        itemPlacer = remember {
                            AxisItemPlacer.Horizontal.default(
                                spacing = 3,
                                addExtremeLabelPadding = true
                            )
                        },
                    ),
                ),
                modelProducer = modelProducer,
                modifier = modifier,
                horizontalLayout = HorizontalLayout.fullWidth(),
            )
        }
    }

    LaunchedEffect(state.candles.isNotEmpty()) {
        withContext(Dispatchers.Default) {
            if(state.candles.isNotEmpty()){
                modelProducer.tryRunTransaction {
                    candlestickSeries(
                        opening = state.candles.map { it.open },
                        closing = state.candles.map { it.close },
                        low = state.candles.map { it.low },
                        high = state.candles.map { it.high },
                    )
                }
                delay(2000L)
            }else{
                CoroutineScope(Dispatchers.IO).launch {
                    onAction(TradingActions.GetCandlesData)
                }
            }
        }
    }
}