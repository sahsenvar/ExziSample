package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText

@Composable
fun SecondaryChartFilterRow(
    modifier: Modifier = Modifier,
    onclickFilter: (Int) -> Unit
) {
    Row(modifier = modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(1) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "MA", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(2) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "EMA", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(3) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "BOLL", size = 12.sp) }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(3) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ){
            VerticalDivider(
                modifier = Modifier
                    .height(13.dp),
                thickness = 1.dp,
                color = Color.White
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(4) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "VOL", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(5) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "MACD", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(6) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "KDJ", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(7) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "RSI", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(8) }
                .padding(vertical = 5.dp, horizontal = 8.dp)
        ) { ExziText(text = "WR", size = 12.sp) }
    }
}