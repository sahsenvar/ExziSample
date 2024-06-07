package com.sahansenvar.exzicasestudy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sahansenvar.core.common.AppDirection
import com.sahansenvar.core.common.bottomBars.BottomBar
import com.sahansenvar.core.common.topBars.TopBar
import com.sahansenvar.core.common.extentions.inject
import com.sahansenvar.core.resource.bottomBars.FindBottomBar
import com.sahansenvar.core.resource.navType
import com.sahansenvar.core.resource.topBars.FindTopBar
import com.sahansenvar.feature.trading.presentation.screens.chartScreen.ChartScreen
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.TradingScreen
import kotlin.reflect.typeOf

@Composable
fun MainPage(
    navController: NavHostController = inject(),
    viewModel: MainViewModel = inject()
) {
    var selectedTopBar: TopBar by remember { mutableStateOf(value = TopBar.None) }
    var selectedBottomBar: BottomBar by remember { mutableStateOf(value = BottomBar.Main) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(14, 17, 27),
        topBar = { FindTopBar(selectedTopBar){ navController.popBackStack()} },
        bottomBar = { FindBottomBar(selectedBottomBar) },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDirection.TradingScreen(),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            composable<AppDirection.TradingScreen>(
                typeMap = mapOf(
                    typeOf<TopBar>() to navType<TopBar>(),
                    typeOf<BottomBar>() to navType<BottomBar>()
                )
            ) {
                it.toRoute<AppDirection.TradingScreen>().apply {
                    selectedTopBar = topBar
                    selectedBottomBar = bottomBar
                }
                TradingScreen()
            }

            composable<AppDirection.ChartScreen>(
                typeMap = mapOf(
                    typeOf<TopBar>() to navType<TopBar>(),
                    typeOf<BottomBar>() to navType<BottomBar>()
                )
            ) {
                it.toRoute<AppDirection.ChartScreen>().apply {
                    selectedTopBar = topBar
                    selectedBottomBar = bottomBar
                }
                ChartScreen()
            }
        }
    }
}