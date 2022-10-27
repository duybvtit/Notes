package com.example.core.base.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

abstract class MvvmViewModel : ViewModel() {
    private val handler = CoroutineExceptionHandler { _, exception ->
        handleError(exception)
    }

    open fun handleError(throwable: Throwable) {}

    open fun startLoading() {}

    protected fun safeLaunch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(handler, block = block)
    }

    protected suspend fun <T> call(
        callFlow: Flow<T>,
        completionHandler: (response: T) -> Unit = {}
    ) {
        callFlow.catch {
            handleError(it)
        }
            .collect {
                completionHandler.invoke(it)
            }
    }
}