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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottomAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStartAxis
import com.patrykandpatrick.vico.compose.cartesian.fullWidth
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberCandlestickCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.core.cartesian.HorizontalLayout
import com.patrykandpatrick.vico.core.cartesian.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.candlestickSeries
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.domain.models.CandleDomain

@SuppressLint("RestrictedApi")
@Composable
fun MainChart(
    modifier: Modifier = Modifier,
    candleDatas: List<CandleDomain>
) {
    val modelProducer = remember { CartesianChartModelProducer.build() }

    if(candleDatas.isNotEmpty()){
        modelProducer.tryRunTransaction {
            candlestickSeries(
                opening = candleDatas.map { it.open },
                closing = candleDatas.map { it.close },
                low = candleDatas.map { it.low },
                high = candleDatas.map { it.high },
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .then(modifier)
                .fillMaxWidth()
                .height(360.dp)
                .background(color = Color(27, 31, 45), shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            if (candleDatas.isEmpty()) {
                Icon(
                    painter = painterResource(id = com.sahansenvar.core.resource.R.drawable.ic_chart_loading),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
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
                    modifier = Modifier.fillMaxSize(),
                    horizontalLayout = HorizontalLayout.fullWidth(),
                )
            }
        }

    }

}