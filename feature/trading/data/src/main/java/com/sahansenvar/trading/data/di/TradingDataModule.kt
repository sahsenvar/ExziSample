package com.sahansenvar.trading.data.di

import com.sahansenvar.core.remote.services.RemoteService
import com.sahansenvar.trading.data.datasource.TradingRemoteSource
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import retrofit2.Retrofit


@Module
@ComponentScan("com.sahansenvar.trading.data")
class TradingDataModule {

    @Factory
    fun provideTradingRemoteSource(
        @Named("SOCKET") retrofit: Retrofit
    ): TradingRemoteSource{
        return retrofit.create(TradingRemoteSource::class.java)
    }
}