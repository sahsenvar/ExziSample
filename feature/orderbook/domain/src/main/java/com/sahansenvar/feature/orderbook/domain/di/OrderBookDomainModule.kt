package com.sahansenvar.feature.orderbook.domain.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

@Module
@ComponentScan("com.sahansenvar.feature.orderbook.domain")
class OrderBookDomainModule{

    @Factory
    fun provideDispatcher() = Dispatchers.IO
}