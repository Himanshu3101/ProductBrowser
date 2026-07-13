package org.himanshu.productbrowser.core.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

open class BaseViewModel {
    protected val viewModelScope = CoroutineScope(
        SupervisorJob()+ Dispatchers.Main
    )

    protected fun launch(
        block: suspend CoroutineScope.() -> Unit
    ){
        viewModelScope.launch{
            block()
        }
    }

    open fun onCleared(){
        viewModelScope.cancel()
    }
}

