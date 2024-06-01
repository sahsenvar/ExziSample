package com.sahansenvar.core.remote.interceptor

import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException

class AppResponseInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val mediaType = "application/json".toMediaType()
        return try {
            val response = chain.proceed(chain.request())
            val newBody = AppResponse.Success(response.body!!)
                .toString()
                .toResponseBody(mediaType)
            if (response.isSuccessful) {
                response.body
                Response.Builder().body(newBody).build()
            } else {
                val errorResponse = when (response.code) {
                    401 -> NetworkError.BadAuthError("Bad Authentication Error")
                    500 -> NetworkError.ServerError("Server Error")
                    else -> NetworkError.UnknownError("Unknown Server Error")
                }.toString().toResponseBody(mediaType)
                Response.Builder().body(errorResponse).build()
            }
        } catch (e: IOException) {
            val body = NetworkError.NoInternetConnection(e.message ?: "")
                .toString()
                .toResponseBody(mediaType)
            return Response.Builder().body(body).build()
        }
    }

}