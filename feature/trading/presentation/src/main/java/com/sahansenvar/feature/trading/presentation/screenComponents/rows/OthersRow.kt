package com.sahansenvar.feature.trading.presentation.screenComponents.rows

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sahansenvar.feature.trading.presentation.screenComponents.dropDownMenus.PercentSelectorDownDownMenu
import com.sahansenvar.core.resource.R

@Composable
fun OthersRow(
    modifier: Modifier = Modifier,
    onSelected: (Float) -> Unit,
    goToMarket: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PercentSelectorDownDownMenu(
                modifier = Modifier.weight(1f),
                onSelected = onSelected
            )
            Icon(
                modifier = Modifier
                    .clickable { goToMarket()}
                    .weight(0.4f),
                painter = painterResource(id = R.drawable.ic_panel),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}


@Preview
@Composable
private fun Preview() {
    OthersRow(onSelected = {}, goToMarket = {})
}