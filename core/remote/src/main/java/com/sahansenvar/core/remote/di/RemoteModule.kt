package com.sahansenvar.core.remote.di

import BuildConfig
import com.sahansenvar.core.remote.services.RemoteService
import okhttp3.Interceptor
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
class RemoteModule {

    @Single
    @Named("SOCKET")
    fun provideRetrofitForSocket(
        interceptor: Interceptor? = null
    ): Retrofit{
        return RemoteService.createRetrofit(BuildConfig.SOCKET_URL, interceptor)
    }

    @Single
    @Named("API")
    fun provideRetrofitForApi(
        interceptor: Interceptor? = null
    ): Retrofit{
        return RemoteService.createRetrofit(BuildConfig.API_URL, interceptor)
    }
}