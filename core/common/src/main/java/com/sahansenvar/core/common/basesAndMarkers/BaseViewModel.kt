package com.sahansenvar.core.common.basesAndMarkers

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<STATE: UiState>(
     state: STATE
): ViewModel() {
    protected val _state: MutableStateFlow<STATE> = MutableStateFlow(state)
    val state: StateFlow<STATE>
        get() = _state
}