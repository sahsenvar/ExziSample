package com.sahansenvar.exzicasestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.sahansenvar.core.common.constants.Properties
import com.sahansenvar.core.common.extentions.inject
import com.sahansenvar.feature.trading.presentation.screens.TradingScreenBluePrint
import org.koin.android.ext.android.getKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            getKoin().setProperty(Properties.NAV_CONTROLLER, rememberNavController())
            MainPage()
        }
    }
}