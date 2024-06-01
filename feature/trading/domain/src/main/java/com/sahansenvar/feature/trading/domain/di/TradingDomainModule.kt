package com.sahansenvar.feature.trading.domain.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import kotlin.coroutines.CoroutineContext
@Module
@ComponentScan("com.sahansenvar.feature.trading.domain")
class TradingDomainModule {

    @Factory
    fun provideDispatcher() = Dispatchers.IO
}