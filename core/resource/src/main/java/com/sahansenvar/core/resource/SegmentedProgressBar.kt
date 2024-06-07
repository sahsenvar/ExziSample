package com.sahansenvar.core.resource

import androidx.annotation.IntRange
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SegmentedProgressBar(
    modifier: Modifier = Modifier,
    @IntRange(0, 5) whichActive: Int = 0,
    onClicked: (Float) -> Unit
) {
    var activePercent by remember { mutableIntStateOf(whichActive) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(bottom = 3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.clickable { activePercent = 0; onClicked(0f) },
                painter = painterResource(if (activePercent == 0) R.drawable.ic_ellipse_active else R.drawable.ic_ellipse_passive),
                contentDescription = null,
                tint = if (0 == activePercent) Color.White else Color.DarkGray
            )
            repeat(4) {
                Spacer(
                    modifier = Modifier
                        .weight(0.5f)
                        .height(1.dp)
                        .background(color = Color(66, 77, 112))
                )
                Icon(
                    modifier = Modifier.clickable { activePercent = it + 1; onClicked(0.25f) },
                    painter = painterResource(if (activePercent == it + 1) R.drawable.ic_ellipse_active else R.drawable.ic_ellipse_passive),
                    contentDescription = null,
                    tint = if (it + 1 == activePercent) Color.White else Color.DarkGray
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            repeat(5){
                ExziText(text = "%${it.times(25)}", size = 10.sp, align = TextAlign.Center)
            }

        }
    }

}

@Preview
@Composable
private fun Preview() {
    SegmentedProgressBar {

    }
}