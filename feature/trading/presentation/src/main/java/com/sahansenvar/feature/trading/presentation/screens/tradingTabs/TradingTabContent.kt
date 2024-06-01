package com.sahansenvar.feature.trading.presentation.screens.tradingTabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TradingTabContent(

) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
            .padding(0.dp),
        contentColor = Color.White,
        containerColor = Color.Black,
        indicator = { },
        divider = { }
    ) {
        TradingTabItem.entries.forEachIndexed { index, item ->
            Tab(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(0.dp),
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                text = {
                    Text(
                        text = item.title,
                        fontWeight = if (selectedTabIndex == index)
                            FontWeight.Bold
                        else FontWeight.Normal
                    )

                }
            )
        }
    }
}


//{
//    var selectedTabIndex by remember { mutableIntStateOf(0) }
//    TabRow(
//        modifier = Modifier.wrapContentWidth(Alignment.Start),
//        selectedTabIndex = selectedTabIndex
//    ){
//        Tab(
//            selected = true,
//
//        )
//        //tradingTabItems.forEachIndexed{ index, item, ->
//        //    Tab(
//        //        modifier = Modifier.wrapContentSize(),
//        //        selected = index == selectedTabIndex,
//        //        onClick = { selectedTabIndex = index },
//        //        text = { Text(item.title)}
//        //    )
//        //}
//    }
//}