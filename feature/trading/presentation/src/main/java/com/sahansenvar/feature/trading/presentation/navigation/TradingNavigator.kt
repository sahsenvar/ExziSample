package com.sahansenvar.feature.trading.presentation.navigation;

import androidx.navigation.NavHostController
import com.sahansenvar.core.common.AppDirection
import com.sahansenvar.core.common.bottomBars.BottomBar
import com.sahansenvar.core.common.topBars.TopBar

import org.koin.core.annotation.Factory;
import org.koin.core.annotation.Property;

@Factory
class TradingNavigator(
    @Property("NavController") val navController: NavHostController
) {

    fun goToGraphScreen(
        title: String
    ) = navController.navigate(
        AppDirection.ChartScreen(
            topBar = TopBar.BackXTitle(title = title),
        )
    )

}