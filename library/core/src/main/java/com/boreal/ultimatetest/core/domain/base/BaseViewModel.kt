package com.boreal.ultimatetest.core.domain.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Base ViewModel class to handle common logic
 * @see Hereda de ViewModel, no necesita implementar nada, solo se encarga de manejar la lógica común
 */
abstract class BaseViewModel : ViewModel() {

    protected fun executeFlow(block: suspend () -> Unit) = viewModelScope.launch {
        try {
            block.invoke()
        } catch (e: Exception) {
            e.stackTraceToString().log("ERROR_VMODEL")
        }
    }
}