package com.sahansenvar.feature.trading.presentation.screenComponents.dropDownMenus

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText

@Composable
fun PercentSelectorDownDownMenu(
    modifier: Modifier = Modifier,
    firstSelected: Float = 1f,
    firstExpanded: Boolean = false,
    onSelected: (Float) -> Unit
) {
    var isExpanded by remember{ mutableStateOf(firstExpanded)}
    ExziDropDownMenu(
        modifier = modifier,
        isExpanded = isExpanded,
        onClickToRow = { isExpanded = !isExpanded },
        title = { ExziText(modifier = Modifier.padding(start = 10.dp), text = firstSelected.toString().format("%.1f"), size = 12.sp)},
        trailingIcon = { Icon(
            modifier = Modifier.padding(end = 10.dp),
            painter = painterResource(
                id = if (isExpanded) com.sahansenvar.core.resource.R.drawable.ic_arrow_up else com.sahansenvar.core.resource.R.drawable.ic_arrow_bottom
            ),
            contentDescription = null,
            tint = Color(111, 125, 170)
        )},
        onDismissRequest = { isExpanded = false },
        menuItemList = listOf(1f,2f, 3f, 4f)
    ) {
        ExziText(
            modifier
                .padding(start = 10.dp)
                .clickable { onSelected(it) },
            text = it.toString().format("%.1f"),
            size = 10.sp
        )
    }
}

@Preview
@Composable
private fun Preview() {
    PercentSelectorDownDownMenu {

    }
}