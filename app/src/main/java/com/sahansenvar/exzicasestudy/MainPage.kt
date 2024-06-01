package com.sahansenvar.exzicasestudy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sahansenvar.core.common.AppDirection
import com.sahansenvar.core.common.extentions.inject
import com.sahansenvar.feature.orderbook.presentation.screens.OrderBookPage
import com.sahansenvar.feature.trading.presentation.screens.TradingPage
import com.sahansenvar.feature.trading.presentation.screens.generalBacgroundColor

@Composable
fun MainPage(
    navController: NavHostController = inject(),
    viewModel: MainViewModel = inject()
) {
    Scaffold(
        Modifier.fillMaxSize(),
        containerColor = generalBacgroundColor
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDirection.TradingScreen,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            composable<AppDirection.TradingScreen> { TradingPage() }
            composable<AppDirection.OrderbookScreen> { OrderBookPage() }
        }
    }
}