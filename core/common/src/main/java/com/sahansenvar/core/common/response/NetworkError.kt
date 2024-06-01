package com.sahansenvar.core.common.response

sealed interface NetworkError : AppError {
    data class NoInternetConnection(override val message: String) : NetworkError
    data class ServerError(override val message: String) : NetworkError
    data class BadAuthError(override val message: String) : NetworkError
    data class UnknownError(override val message: String): NetworkError
}