package com.sahansenvar.exzicasestudy

import BuildConfig
import android.app.Application
import com.core.api.remote.interceptor.FlipperNetworkObject
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.core.FlipperClient
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import com.sahansenvar.core.remote.di.RemoteModule
import com.sahansenvar.feature.trading.domain.di.TradingDomainModule
import com.sahansenvar.feature.trading.presentation.di.TradingPresentationModule
import com.sahansenvar.trading.data.di.TradingDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ExziApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initFlipper()
    }


    private fun initKoin() = startKoin {
        androidContext(this@ExziApp)
        androidLogger()
        modules(
            MainModule().module,

            RemoteModule().module,

            TradingDataModule().module,
            TradingDomainModule().module,
            TradingPresentationModule().module,
        )
    }

    private fun initFlipper() {
        SoLoader.init(this, false)
        if (BuildConfig.isDebuggable && FlipperUtils.shouldEnableFlipper(this)) {
            val clint: FlipperClient = AndroidFlipperClient.getInstance(this)
            val networkFlipperPlugin = NetworkFlipperPlugin()
            FlipperNetworkObject.networkFlipperPlugin = networkFlipperPlugin
            clint.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            clint.addPlugin(SharedPreferencesFlipperPlugin(this, "BitHubFlipperPlugin"))
            clint.addPlugin(networkFlipperPlugin)
            clint.start()
        }
    }

}