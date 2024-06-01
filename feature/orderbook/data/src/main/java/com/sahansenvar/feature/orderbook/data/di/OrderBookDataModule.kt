package com.sahansenvar.feature.orderbook.data.di

import com.sahansenvar.feature.orderbook.data.datasource.OrderBookRemoteSource
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import retrofit2.Retrofit

@Module
@ComponentScan("com.sahansenvar.feature.orderbook.data")
class OrderBookDataModule {

    @Factory
    fun provideOrderBookRemoteSource(
        @Named("API") retrofit: Retrofit
    ): OrderBookRemoteSource {
        return retrofit.create(OrderBookRemoteSource::class.java)
    }

}