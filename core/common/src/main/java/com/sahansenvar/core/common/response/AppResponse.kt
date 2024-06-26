package com.sahansenvar.core.common.response

import com.sahansenvar.core.common.basesAndMarkers.ComponentState
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppResponse<out DATA, out CAUSE : AppError> {
    @Serializable
    data class Success<out DATA>(val data: DATA) : AppResponse<DATA, Nothing>
    @Serializable
    data class Failure<CAUSE : AppError>(val cause: CAUSE) : AppResponse<Nothing, CAUSE>
    @Serializable
    data object Loading : AppResponse<Nothing, Nothing>
}

// Extension Properties
val <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.data
    get() = if (this is AppResponse.Success) this.data else null

val <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.cause
    get() = if (this is AppResponse.Failure) this.cause else null

val <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.isSuccess
    get() = if (this is AppResponse.Success) true else false

val <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.isFailure
    get() = if (this is AppResponse.Failure) true else false

fun <OLD_DATA, CAUSE : AppError, NEW_DATA> AppResponse<OLD_DATA, CAUSE>.map(mapProccess: (OLD_DATA) -> NEW_DATA): AppResponse<NEW_DATA, CAUSE> {
    return if (isSuccess)
        AppResponse.Success(mapProccess.invoke(data!!))
    else
        AppResponse.Failure(cause!!)
}

fun <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.onLoading(block: () -> Unit): AppResponse<DATA, CAUSE> {
    if (this is AppResponse.Loading)
        block.invoke()
    return this
}

inline fun <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.onSuccess(block: (DATA) -> Unit): AppResponse<DATA, CAUSE> {
    if (this is AppResponse.Success)
        block.invoke(data)
    return this
}

fun <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.onFailure(block: (CAUSE) -> Unit): AppResponse<DATA, CAUSE> {
    if (this is AppResponse.Failure)
        block.invoke(cause)
    return this
}

val <DATA, CAUSE : AppError> AppResponse<DATA, CAUSE>.componentState
    get() = when (this) {
        is AppResponse.Failure -> ComponentState.Failure(this.cause.message)
        is AppResponse.Loading -> ComponentState.Loading()
        is AppResponse.Success -> ComponentState.Success()
    }