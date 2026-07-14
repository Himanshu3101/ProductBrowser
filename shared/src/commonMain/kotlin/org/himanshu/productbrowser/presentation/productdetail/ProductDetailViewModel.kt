package org.himanshu.productbrowser.presentation.productdetail

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.himanshu.productbrowser.core.presentation.BaseViewModel
import org.himanshu.productbrowser.domain.usecase.GetProductUseCase

class ProductDetailViewModel(
    private val getProductUseCase: GetProductUseCase
): BaseViewModel(){

    private val _state = MutableStateFlow(ProductDetailState())
    val state: StateFlow<ProductDetailState> = _state.asStateFlow()

    fun onEvent(event: ProductDetailEvent){
        when(event) {
            is ProductDetailEvent.LoadProduct -> loadProduct(event.productId)
        }
    }

    private fun loadProduct(productId: Int) {
        launch {
            updateState {
                copy(isLoading = true)
            }

            runCatching {
                getProductUseCase(productId)
            }.onSuccess { product ->
                updateState {
                    copy(
                        isLoading = false,
                        product = product
                    )
                }
            }.onFailure { exception ->
                updateState {
                    copy(
                        isLoading = false,
                        error = exception.message?: "Something went wrong..,"
                    )
                }
            }
        }
    }

    private fun updateState(reducer: ProductDetailState.() -> ProductDetailState) {
        _state.value = _state.value.reducer()
    }


}