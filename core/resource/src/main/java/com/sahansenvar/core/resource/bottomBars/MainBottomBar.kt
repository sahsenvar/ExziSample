package com.sahansenvar.core.resource.bottomBars

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.core.resource.R

@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier
){
    var selectedItem by remember { mutableIntStateOf(2) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        NavigationBar(
            containerColor = Color(21, 24, 35)
        ) {
            MainBottomBarItem.entries.forEach { item ->
                NavigationBarItem(
                    selected = selectedItem == item.ordinal,
                    onClick = { selectedItem = item.ordinal },
                    label = {
                        ExziText(text = item.title, size = 10.sp)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = Color.White,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
        FloatingActionButton(
            modifier = Modifier.padding(bottom = 65.dp),
            shape = CircleShape,
            containerColor = Color.White,
            onClick = {  }
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.ic_tradingg),
                contentDescription = null,
                tint = Color(21, 24, 35)
            )
        }
    }
}

enum class MainBottomBarItem(val title: String, val icon: Int) {
    EXZi("EXZi", R.drawable.ic_exzi),
    Market("Market", R.drawable.ic_candles),
    Trade("Trade", R.drawable.ic_candles),
    Copy("Copy", R.drawable.ic_copyy),
    Assets("Assets", R.drawable.ic_assets)
}