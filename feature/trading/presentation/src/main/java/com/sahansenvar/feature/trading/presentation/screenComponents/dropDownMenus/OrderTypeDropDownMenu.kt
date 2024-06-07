package com.sahansenvar.feature.trading.presentation.screenComponents.dropDownMenus

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.core.resource.R
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.orderEntryTabPage.OrderType

@Composable
fun OrderTypeDropDownMenu(
    modifier: Modifier = Modifier,
    menuModifier: Modifier = Modifier,
    isExpandedAtStarted: Boolean = false,

) {
    var selectedOrderType by remember { mutableStateOf(OrderType.Limit) }
    var isExpanded by remember { mutableStateOf(isExpandedAtStarted) }

    ExziDropDownMenu(
        modifier = modifier,
        menuModifier = menuModifier,
        onClickToRow = { isExpanded = !isExpanded},
        onDismissRequest = {isExpanded = false},
        menuItemList = OrderType.entries,
        isExpanded = isExpanded,
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(start = 10.dp),
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = null,
                tint = Color(111, 125, 170)
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.padding(end = 10.dp),
                painter = painterResource(
                    id = if (isExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_bottom
                ),
                contentDescription = null,
                tint = Color(111, 125, 170)
            )
        },
        title = { ExziText(modifier = Modifier, text = selectedOrderType.name, size = 12.sp) },
        eachContentFor = {
            val context = LocalContext.current
            DropdownMenuItem(
                modifier = Modifier,
                text = { ExziText(modifier = Modifier.background(Color.Transparent), text = it.name, size = 12.sp) },
                onClick = {
                    selectedOrderType = it
                    isExpanded = false
                    Toast.makeText(
                        context,
                        "OrderType has changed! (${it.name})",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }
    )
}

@Composable
fun <T : Any> ExziDropDownMenu(
    modifier: Modifier,
    menuModifier: Modifier = Modifier,
    isExpanded: Boolean,
    onClickToRow: () -> Unit,
    onDismissRequest: () -> Unit,
    menuItemList: List<T>,
    leadingIcon: @Composable () -> Unit = {},
    title: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    eachContentFor: @Composable ColumnScope.(T) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .border(
                    width = 0.5.dp,
                    shape = RoundedCornerShape(4.dp),
                    color = Color(66, 77, 112)
                )
                .fillMaxWidth()
                .heightIn(35.dp)
                .clickable { onClickToRow() },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon()
            title()
            trailingIcon()
        }
        DropdownMenu(
            modifier = Modifier
                .heightIn(35.dp)
                .then(menuModifier)
                .fillMaxWidth()
                .background(color = Color(14, 17, 27))
                .border(
                    width = 0.5.dp,
                    shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp),
                    color = Color(66, 77, 112)
                ),
            expanded = isExpanded,
            onDismissRequest = { onDismissRequest() },
        ) {
            menuItemList.forEach { eachContentFor(it) }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    ExziDropDownMenu(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 0.5.dp,
                shape = RoundedCornerShape(4.dp),
                color = Color(66, 77, 112)
            ),
        isExpanded = false,
        onClickToRow = {},
        onDismissRequest = {},
        menuItemList = listOf("item1", "item2", "item3", "item4"),
        eachContentFor = {
            DropdownMenuItem(
                modifier = Modifier
                    .heightIn(35.dp)
                    .background(color = Color(14, 17, 27)),
                text = {
                    ExziText(modifier = Modifier, text = it, size = 13.sp, color = Color.White)
                },
                onClick = {}
            )
        }
    )
}

@Preview
@Composable
private fun Preview2() {
    OrderTypeDropDownMenu(
        modifier = Modifier,
    )
}