package org.himanshu.productbrowser.presentation.productlist

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.himanshu.productbrowser.core.presentation.BaseViewModel
import org.himanshu.productbrowser.domain.usecase.GetProductsUseCase
import org.himanshu.productbrowser.domain.usecase.SearchProductsUseCase

class ProductListViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val searchProductsUseCase: SearchProductsUseCase
): BaseViewModel(){

    private val _state = MutableStateFlow(ProductListState())

    val state: StateFlow<ProductListState> = _state.asStateFlow()

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        launch {
          updateState {
              copy(
                  isLoading = true
              )
          }

            runCatching {
                getProductsUseCase()
            }.onSuccess { products ->
                updateState {
                    copy(
                        isLoading = false,
                        products = products
                    )
                }
            }.onFailure { exception ->
                updateState {
                    copy(
                        isLoading = false,
                        error = exception.message ?: "Something went wrong"
                    )
                }
            }
        }
    }

    private fun updateState(
        reducer: ProductListState.()-> ProductListState
    ){
        _state.value = _state.value.reducer()
    }
}