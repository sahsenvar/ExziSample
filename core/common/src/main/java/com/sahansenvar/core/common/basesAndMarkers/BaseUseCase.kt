package com.sahansenvar.core.common.basesAndMarkers

import com.sahansenvar.core.common.response.AppError
import com.sahansenvar.core.common.response.AppResponse
import com.sahansenvar.core.common.response.NetworkError
import com.sahansenvar.core.common.response.onSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

abstract class BaseUseCase(
    private val dispatcher: CoroutineContext
) {

    protected fun runSyncUseCase(block: () -> Unit) {
        // ...
    }

    protected fun <DATA> runAsyncUseCase(body: suspend () -> DATA) = flow {
        emit(AppResponse.Loading)
        kotlin.runCatching {
            val response = body.invoke()
            emit(AppResponse.Success(response))
        }.onFailure {
            emit(AppResponse.Failure(NetworkError.UnknownError(it.message ?: "unknown error")))
        }
    }.flowOn(dispatcher)
}