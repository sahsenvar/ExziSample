package com.sahansenvar.core.remote.services

import BuildConfig
import com.core.api.remote.interceptor.FlipperNetworkObject
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sahansenvar.core.common.basesAndMarkers.RemoteSource
import com.sahansenvar.core.remote.interceptor.AppResponseInterceptor
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

object RemoteService {
    private fun createHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.isDebuggable) Level.BODY else Level.NONE
    }

    private fun createOkHttpClient(
        interceptor: Interceptor? = null
    ) = OkHttpClient.Builder().apply {
        connectTimeout(60L, TimeUnit.SECONDS)
        readTimeout(60L, TimeUnit.SECONDS)
        addInterceptor(createHttpLoggingInterceptor())
        FlipperNetworkObject.networkFlipperPlugin?.let { plugin ->
            addNetworkInterceptor(FlipperOkhttpInterceptor(plugin))
        }
        addInterceptor(AppResponseInterceptor())
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