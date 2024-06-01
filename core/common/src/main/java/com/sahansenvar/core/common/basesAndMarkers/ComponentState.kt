package com.sahansenvar.core.common.basesAndMarkers

sealed interface ComponentState {
    data object Idle : ComponentState
    data class Loading(val message: String = "") : ComponentState
    data class Success(val message: String = "") : ComponentState
    data class Failure(val message: String) : ComponentState
}