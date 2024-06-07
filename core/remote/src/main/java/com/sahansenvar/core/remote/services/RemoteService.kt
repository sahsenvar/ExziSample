package com.sahansenvar.core.remote.services

import BuildConfig
import com.core.api.remote.interceptor.FlipperNetworkObject
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sahansenvar.core.common.basesAndMarkers.RemoteSource
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit

object RemoteService {

    private fun createOkHttpClient(
        interceptor: Interceptor? = null
    ) = OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.isDebuggable) {
                Level.BODY
            } else {
                Level.NONE
            }
        })
        FlipperNetworkObject.networkFlipperPlugin?.let { plugin ->
            addNetworkInterceptor(FlipperOkhttpInterceptor(plugin))
        }
        interceptor?.let { addInterceptor(interceptor) }
    }.build()

    private val jsonBuilder = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }

    fun createRetrofit(
        baseUrl: String,
        interceptor: Interceptor? = null
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createOkHttpClient(interceptor))
            .addConverterFactory(jsonBuilder.asConverterFactory(contentType))
            .build()
    }

    inline fun <reified T: RemoteSource> createRemoteSource(retrofit: Retrofit): T {
        return retrofit.create(T::class.java)
    }
}