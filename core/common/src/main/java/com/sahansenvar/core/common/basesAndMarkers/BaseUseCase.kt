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

    protected fun runSyncUseCase( block: () -> Unit ){

    }

    protected fun <DATA, ERROR: AppError> runAsyncUseCase(body: suspend () -> AppResponse<DATA, ERROR>) = flow {
        emit(AppResponse.Loading)
        when (val response: AppResponse<DATA, ERROR> = body.invoke()) {
            is AppResponse.Success -> emit(AppResponse.Success(response.data))
            is AppResponse.Failure -> emit(AppResponse.Failure(response.cause))
            else -> throw Exception("")
        }
    }.catch {
        // todo will handle soon
    }.flowOn(dispatcher)
}