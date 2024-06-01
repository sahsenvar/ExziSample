package com.sahansenvar.feature.trading.presentation.navigation;

import androidx.navigation.NavHostController
import com.sahansenvar.core.common.AppDirection

import org.koin.core.annotation.Factory;
import org.koin.core.annotation.Property;

@Factory
class TradingNavigator(
    @Property("NavController") val navController: NavHostController
) {

    fun goToOrderBook() = navController.navigate(AppDirection.OrderbookScreen)

}