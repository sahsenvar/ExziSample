package com.sahansenvar.feature.trading.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.common.extentions.inject
import com.sahansenvar.feature.trading.presentation.navigation.TradingNavigator
import com.sahansenvar.feature.trading.presentation.screens.tradingTabs.TradingTabContent
import com.sahansenvar.feature.trading.presentation.screens.tradingTabs.TradingTabItem
import com.sahansenvar.feature.trading.presentation.viewModels.TradingViewModel

@Composable
fun TradingPage(
    viewModel: TradingViewModel = inject(),
    navigator: TradingNavigator = inject()
) {
    var selectedTabItem: TradingTabItem by remember { mutableStateOf(TradingTabItem.Spot) }
    Column {
        TabRow(
            selectedTabIndex = selectedTabItem.ordinal,
            containerColor = Color.Transparent,
            indicator = {},
            divider = {}
        ) {
            TradingTabItem.entries.forEach { item ->
                Tab(
                    selected = selectedTabItem == item,
                    onClick = { selectedTabItem = item },
                    selectedContentColor = selectedTextColor,
                    unselectedContentColor = unSelectedTextColor,
                    text = { Text(text = item.title, fontSize = 15.sp) }
                )
            }
        }
        Box(modifier = Modifier.fillMaxSize(), content = { selectedTabItem.content })
    }
}

