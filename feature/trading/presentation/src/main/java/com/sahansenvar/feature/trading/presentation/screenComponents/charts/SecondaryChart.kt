package com.sahansenvar.feature.trading.presentation.screenComponents.charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sahansenvar.core.resource.R

@Composable
fun SecondaryChart(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .height(115.dp)
            .background(color = Color(27, 31, 45), shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_chart_loading),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}