package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                .padding(5.dp)
        ) { ExziText(text = "Line", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(2) }
                .padding(5.dp)
        ) { ExziText(text = "15m", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(3) }
                .padding(5.dp)
        ) { ExziText(text = "1h", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(4) }
                .padding(5.dp)
        ) { ExziText(text = "4h", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(5) }
                .padding(5.dp)
        ) { ExziText(text = "1d", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(6) }
                .padding(5.dp)
        ) { ExziText(text = "1w", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(7) }
                .padding(5.dp)
        ) { ExziText(text = "1w", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(8) }
                .padding(5.dp)
        ) { ExziText(text = "More", size = 12.sp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onclickFilter(9) }
                .padding(5.dp)
        ) { ExziText(text = "Deepth", size = 12.sp) }
    }
}